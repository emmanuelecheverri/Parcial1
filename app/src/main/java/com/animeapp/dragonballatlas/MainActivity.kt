package com.animeapp.dragonballatlas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage

private val Ink = Color(0xFF111827)
private val Ember = Color(0xFFFF7A1A)
private val Gold = Color(0xFFFFC857)
private val Mist = Color(0xFFF4F1EA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme(colorScheme = lightColorScheme(primary = Ember, secondary = Color(0xFF1769AA), background = Mist)) { AtlasApp() } }
    }
}

@Composable
private fun AtlasApp() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "atlas") {
        composable("atlas") { AtlasScreen { nav.navigate("fighter/${it}") } }
        composable("fighter/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { entry ->
            characters.firstOrNull { it.id == entry.arguments?.getInt("id") }?.let { FighterScreen(it) { nav.popBackStack() } }
        }
    }
}

@Composable
private fun AtlasScreen(onOpen: (Int) -> Unit) {
    var selected by remember { mutableStateOf<Role?>(null) }
    val shown = characters.filter { selected == null || it.role == selected }
    Column(Modifier.fillMaxSize().background(Mist)) {
        Column(Modifier.fillMaxWidth().background(Brush.linearGradient(listOf(Color(0xFF192B45), Color(0xFF253C5A), Ember))).padding(horizontal = 22.dp, vertical = 24.dp)) {
            Text("DRAGON BALL  /  ARCHIVO DE COMBATE", color = Gold, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(12.dp))
            Text("Atlas de\nguerreros", color = Color.White, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Black, lineHeight = MaterialTheme.typography.headlineLarge.lineHeight)
            Spacer(Modifier.height(8.dp))
            Text("20 perfiles · 7 universos · poder sin límites", color = Color(0xFFE5E7EB), style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(18.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                FilterPill("Todos", selected == null) { selected = null }
                FilterPill("Guerreros Z", selected == Role.HERO) { selected = Role.HERO }
                FilterPill("Amenazas", selected == Role.VILLAIN) { selected = Role.VILLAIN }
            }
        }
        Row(Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(if (selected == Role.HERO) "EQUIPO TIERRA" else if (selected == Role.VILLAIN) "ARCHIVOS DE AMENAZAS" else "REGISTRO COMPLETO", color = Ink, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            Text("${shown.size} luchadores", color = Color.Gray, style = MaterialTheme.typography.labelMedium)
        }
        LazyColumn(contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(shown, key = { it.id }) { fighter -> FighterCard(fighter) { onOpen(fighter.id) } }
        }
    }
}

@Composable
private fun FilterPill(label: String, active: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(50), color = if (active) Gold else Color(0x33FFFFFF), contentColor = if (active) Ink else Color.White) {
        Text(label, Modifier.padding(horizontal = 14.dp, vertical = 9.dp), style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun FighterCard(fighter: Character, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            Box(Modifier.size(92.dp).clip(RoundedCornerShape(16.dp)).background(Brush.linearGradient(listOf(Color(0xFFFFE0A3), Color(0xFFFFF5E6))))) {
                AsyncImage(model = fighter.image, contentDescription = fighter.name, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                Text("#${fighter.id.toString().padStart(2, '0')}", Modifier.align(Alignment.BottomStart).background(Ink.copy(alpha = .82f)).padding(horizontal = 7.dp, vertical = 3.dp), color = Color.White, style = MaterialTheme.typography.labelSmall)
            }
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(fighter.role.label.uppercase(), color = if (fighter.role == Role.HERO) Color(0xFF1769AA) else Ember, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                Text(fighter.name, color = Ink, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text(fighter.powers.take(2).joinToString("  ·  "), color = Color.DarkGray, style = MaterialTheme.typography.bodySmall, maxLines = 1)
                Text("VER FICHA  ↗", color = Ember, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun FighterScreen(fighter: Character, onBack: () -> Unit) {
    val profile = when {
        fighter.powers.any { it.contains("ki", true) || it.contains("energía", true) } -> "Maestro del ki"
        fighter.powers.any { it.contains("Saiyajin", true) } -> "Guerrero Saiyajin"
        fighter.powers.any { it.contains("Magia", true) || it.contains("Hechicería", true) } -> "Poder místico"
        else -> "Combatiente élite"
    }
    val powerLevel = (fighter.powers.size * 25).coerceAtMost(100)
    LazyColumn(Modifier.fillMaxSize().background(Mist), contentPadding = PaddingValues(bottom = 28.dp)) {
        item {
            Box(Modifier.fillMaxWidth().height(320.dp).background(Brush.verticalGradient(listOf(Color(0xFF1D3552), Ember)))) {
                AsyncImage(model = fighter.image, contentDescription = fighter.name, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                Column(Modifier.align(Alignment.BottomStart).fillMaxWidth().background(Brush.verticalGradient(listOf(Color.Transparent, Ink.copy(alpha = .94f)))).padding(22.dp)) {
                    Text("${fighter.role.label.uppercase()}  ·  PERFIL #${fighter.id.toString().padStart(2, '0')}", color = Gold, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                    Text(fighter.name, color = Color.White, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Black)
                }
            }
        }
        item { Text("←  VOLVER AL ATLAS", Modifier.clickable(onClick = onBack).padding(horizontal = 22.dp, vertical = 16.dp), color = Color(0xFF1769AA), style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold) }
        item {
            Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(fighter.description, color = Ink, style = MaterialTheme.typography.bodyLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    StatTile("CLASE", profile, Modifier.weight(1f))
                    StatTile("TÉCNICAS", "${fighter.powers.size}", Modifier.weight(1f))
                    StatTile("KI", "$powerLevel%", Modifier.weight(1f))
                }
                Column(Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(Color.White).padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("TÉCNICAS DE COMBATE", color = Ink, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    fighter.powers.forEach { Text("✦   $it", color = Color(0xFF374151), style = MaterialTheme.typography.bodyMedium) }
                }
                Column(Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(Color(0xFFFFE5C5)).padding(18.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("ORIGEN", color = Ember, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                    Text(fighter.origin, color = Ink, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    Text("${fighter.name} domina ${fighter.powers.first()} y cuenta con ${fighter.powers.size} técnicas registradas en el atlas.", color = Ink, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier.clip(RoundedCornerShape(16.dp)).background(Ink).padding(vertical = 14.dp, horizontal = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = Gold, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text(label, color = Color.White, style = MaterialTheme.typography.labelSmall)
    }
}
