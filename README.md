# Dragon Ball Atlas

Aplicación Android desarrollada con Kotlin y Jetpack Compose. Presenta un atlas de personajes de Dragon Ball con diez héroes y diez villanos.

## Requisitos

- Android Studio con soporte para proyectos Gradle y Kotlin.
- JDK 17 para ejecutar Gradle.
- Conexión a internet para descargar dependencias y cargar las imágenes de los personajes.

## Abrir el proyecto

1. Abre Android Studio y selecciona **Open**.
2. Elige la carpeta `AnimeApp` (la carpeta que contiene `settings.gradle.kts`).
3. Espera a que Android Studio sincronice Gradle.
4. Ejecuta la configuración `app` en un emulador o dispositivo Android.

También puedes compilar desde una terminal en la raíz del proyecto:

```powershell
./gradlew.bat assembleDebug
```

El APK de depuración se genera en `app/build/outputs/apk/debug/app-debug.apk`.

## Funciones

- Explorar los 20 personajes en una lista.
- Filtrar entre todos, Guerreros Z y amenazas.
- Abrir una ficha individual para cada personaje.
- Consultar descripción, origen, técnicas y estadísticas derivadas del perfil.
- Cargar retratos remotos mediante Coil.

## Estructura principal

```text
app/src/main/
├── AndroidManifest.xml
└── java/com/animeapp/dragonballatlas/
    ├── Character.kt       # Modelo, categorías y catálogo de 20 personajes
    └── MainActivity.kt    # Navegación y pantallas Compose
```

## Tecnologías

- Kotlin
- Jetpack Compose y Material 3
- Navigation Compose
- Coil Compose
- Gradle Kotlin DSL
