package com.animeapp.dragonballatlas

data class Character(
    val id: Int,
    val name: String,
    val role: Role,
    val image: String,
    val description: String,
    val powers: List<String>,
    val origin: String
)

enum class Role(val label: String) { HERO("Guerreros Z"), VILLAIN("Amenazas") }

val characters = listOf(
    Character(1,"Goku",Role.HERO,"https://dragonball-api.com/characters/goku_normal.webp","Saiyajin criado en la Tierra. Su espíritu de superación lo lleva a buscar rivales cada vez más fuertes.",listOf("Kamehameha","Kaioken","Teletransportación","Ultra Instinto"),"Planeta Vegeta"),
    Character(2,"Vegeta",Role.HERO,"https://dragonball-api.com/characters/vegeta_normal.webp","Príncipe de los Saiyajin. Su orgullo y disciplina lo convierten en uno de los defensores más poderosos de la Tierra.",listOf("Final Flash","Galick Gun","Final Explosion","Ultra Ego"),"Planeta Vegeta"),
    Character(3,"Gohan",Role.HERO,"https://dragonball-api.com/characters/gohan.webp","Hijo de Goku y Chi-Chi. Combina una gran capacidad de estudio con un potencial de combate extraordinario.",listOf("Masenko","Kamehameha","Bestia","Potencial desbloqueado"),"Tierra"),
    Character(4,"Piccolo",Role.HERO,"https://dragonball-api.com/characters/picolo_normal.webp","Guerrero namekiano y mentor de Gohan. Pasó de ser rival de Goku a convertirse en un aliado indispensable.",listOf("Makankosappo","Regeneración","Granola naranja","Extensión de brazos"),"Namek"),
    Character(5,"Trunks",Role.HERO,"https://dragonball-api.com/characters/trunks_future.webp","Saiyajin de una línea temporal devastada. Viaja al pasado para advertir a los Guerreros Z.",listOf("Espada","Burning Attack","Final Flash","Super Saiyajin"),"Futuro alternativo"),
    Character(6,"Krilin",Role.HERO,"https://dragonball-api.com/characters/krilin_normal.webp","Artista marcial y amigo de Goku desde la infancia. Su valor nunca depende de su estatura ni de su ki.",listOf("Kienzan","Taiyoken","Kamehameha","Control de ki"),"Tierra"),
    Character(7,"Androide 18",Role.HERO,"https://dragonball-api.com/characters/androide18.webp","Antigua rival creada por el Dr. Gero. Eligió una vida propia junto a Krilin y su hija Marron.",listOf("Energía infinita","Disparo de energía","Fuerza aumentada","Combate aéreo"),"Tierra"),
    Character(8,"Maestro Roshi",Role.HERO,"https://dragonball-api.com/characters/maestro_roshi_normal.webp","Legendario maestro de artes marciales que entrenó a Goku y Krilin en los fundamentos del combate.",listOf("Kamehameha","Max Power","Mafuba","Experiencia táctica"),"Tierra"),
    Character(9,"Tien Shinhan",Role.HERO,"https://dragonball-api.com/characters/ten_shin_han_normal.webp","Artista marcial de tres ojos que puso su fuerza al servicio de la Tierra y sus amigos.",listOf("Kikoho","Taiyoken","Brazos múltiples","Vuelo"),"Tierra"),
    Character(10,"Broly",Role.HERO,"https://dragonball-api.com/characters/broly.webp","Saiyajin de poder descomunal que aprende a controlar su fuerza y encuentra un nuevo camino entre sus aliados.",listOf("Furia Saiyajin","Gigantic Roar","Super Saiyajin","Poder creciente"),"Planeta Vampa"),
    Character(11,"Freezer",Role.VILLAIN,"https://dragonball-api.com/characters/Freezer.webp","Tirano galáctico que destruyó el planeta Vegeta y persigue la inmortalidad y el dominio universal.",listOf("Rayo mortal","Forma dorada","Forma Black","Telequinesis"),"Planeta Freezer 79"),
    Character(12,"Cell",Role.VILLAIN,"https://dragonball-api.com/characters/cell_perfect.webp","Bioandroide creado con células de grandes luchadores. Su objetivo es alcanzar la perfección mediante la absorción.",listOf("Kamehameha","Regeneración","Absorción","Barrera energética"),"Tierra"),
    Character(13,"Majin Buu",Role.VILLAIN,"https://dragonball-api.com/characters/majin_boo_gordo.webp","Criatura mágica de enorme poder. Su naturaleza cambia según la forma y las influencias que recibe.",listOf("Rayo de chocolate","Regeneración","Absorción","Transformación"),"Universo 7"),
    Character(14,"Zamasu",Role.VILLAIN,"https://dragonball-api.com/characters/zamasu.webp","Kaioshin que considera defectuosos a los mortales y busca imponer su justicia en todos los universos.",listOf("Cuchilla de ki","Inmortalidad","Réplica divina","Espada de energía"),"Universo 10"),
    Character(15,"Goku Black",Role.VILLAIN,"https://dragonball-api.com/characters/goku_black.webp","Zamasu ocupa el cuerpo de Goku y usa su poder para ejecutar el plan Cero Humanos.",listOf("Guadaña de ki","Super Saiyajin Rosé","Kamehameha oscuro","Rift temporal"),"Futuro alternativo"),
    Character(16,"Dabura",Role.VILLAIN,"https://dragonball-api.com/characters/dabura.webp","Rey del Reino Demoníaco puesto bajo el control de Babidi para despertar a Majin Buu.",listOf("Escupitajo petrificador","Magia demoníaca","Espada","Vuelo"),"Reino Demoníaco"),
    Character(17,"Babidi",Role.VILLAIN,"https://dragonball-api.com/characters/babidi.webp","Hechicero que manipula a guerreros con magia para reunir la energía necesaria para liberar a Majin Buu.",listOf("Control mental","Hechicería","Teletransportación","Barrera mágica"),"Universo 7"),
    Character(18,"Capitán Ginyu",Role.VILLAIN,"https://dragonball-api.com/characters/ginyu.webp","Líder de las Fuerzas Especiales de Freezer. Su técnica de cambio de cuerpo puede cambiar el curso de una batalla.",listOf("Cambio de cuerpo","Rayo galáctico","Poses de combate","Vuelo"),"Planeta Ginyu"),
    Character(19,"Nappa",Role.VILLAIN,"https://dragonball-api.com/characters/nappa.webp","Saiyajin de élite que acompaña a Vegeta en la invasión de la Tierra.",listOf("Explosión de ki","Cañón de energía","Gran fuerza","Resistencia Saiyajin"),"Planeta Vegeta"),
    Character(20,"Rey Piccolo",Role.VILLAIN,"https://dragonball-api.com/characters/picolo_daima.webp","Demonio namekiano que sembró el terror en la Tierra antes de que Goku lo enfrentara.",listOf("Onda explosiva","Regeneración","Creación de descendientes","Juventud restaurada"),"Tierra")
)
