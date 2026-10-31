# Fitness App

Aplicación móvil nativa para Android diseñada para el seguimiento de la condición física, gestión del perfil de usuario y monitorización del peso e Índice de Masa Corporal (IMC). Desarrollada con **Kotlin** y **Jetpack Compose** bajo los estándares de diseño moderno **Material Design 3**.


---

## Capturas y Vistas Principales

### ProfileScreen

Muestra la foto de perfil, el nombre, el correo electrónico, los datos físicos (edad, género, peso y altura), el objetivo seleccionado y el nivel de actividad. Desde el icono de editar se accede a la pantalla de edición.

<img width="401" height="852" alt="image" src="https://github.com/user-attachments/assets/b9ca8dfe-2b2d-427c-8cd2-91d07817f870" />

### EditProfileScreen

Permite modificar el nombre, el correo, la fecha de nacimiento, el objetivo, el nivel de actividad, la altura y el peso. Incluye los botones **Guardar canvis** y **Cancel·lar**.

<img width="390" height="853" alt="image" src="https://github.com/user-attachments/assets/934dc703-9311-4049-b787-c8a2b3b6e77c" />


---

## Características Principales

- **Perfil de Usuario (`ProfileScreen`)**:
  - Resumen visual con avatar, nombre y correo electrónico.
  - Indicadores clave en tarjetas elevadas: **Edad** (calculada automáticamente a partir de la fecha de nacimiento), **Género**, **Peso** y **Altura**.
  - Tarjetas interactivas de **Objetivos** de entrenamiento (*Guanyar massa muscular*, *Millorar la salut*, *Mantenir el pes*) con resaltado de estado activo.
  - Indicador de **Nivel de actividad física**.

- **Edición de Perfil (`EditProfileScreen`)**:
  - Formulario interactivo con control de estado y persistencia de cambios en memoria.
  - Selector de fecha modal con calendario (`DatePickerDialog`).
  - Desplegable integrado (`ExposedDropdownMenu`) para selección de objetivos.
  - Actualización instantánea de datos personales y físicos sin recargas.

- **Control de Peso y Salud (`WeightTrakingScreen` / `CalculadoraIMC`)**:
  - Cálculo automático del **Índice de Masa Corporal (IMC)** basado en peso y altura.
  - Comparativa entre **Peso Actual** y **Peso Objetivo**.
  - Módulo para el registro de nuevas mediciones.

- **Diseño Moderno y Accesible**:
  - Sistema de diseño basado en **Material 3 (M3)** con paleta deportiva (*Emerald & Mint*).
  - Soporte completo para **Tema Claro** y **Tema Oscuro** (`Light/Dark Mode`).
  - Adaptabilidad total a bordes de pantalla (*Edge-to-Edge*) evitando solapamientos con la barra de estado y gestos del sistema.

---

## Tecnologías Utilizadas

- **Lenguaje:** [Kotlin](https://kotlinlang.org/)
- **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (declarativo)
- **Componentes de Diseño:** [Material 3](https://m3.material.io/) & [Material Icons Extended](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons)
- **Gestión de Estados:** Jetpack Compose State (`remember`, `mutableStateOf`, `rememberSaveable`)
- **Sistema de Compilación:** Gradle Kotlin DSL (`build.gradle.kts`) con catálogo de versiones (`libs.versions.toml`)
- **Testing:** JUnit 4 para pruebas unitarias de lógica

---

## Estructura del Proyecto

```text
app/src/main/java/org/insbaixcamp/fitnessapp/
├── MainActivity.kt                     # Actividad principal y orquestador de navegación
├── ui/
│   ├── components/                     # Componentes UI reutilizables
│   │   ├── CalendarDataPicker.kt       # Selector de fecha modal (DatePicker)
│   │   ├── DropdownTextField.kt        # Menú desplegable con ExposedDropdownMenuBox
│   │   └── MenuDesplegable.kt          # Componente auxiliar de menú
│   ├── data/
│   │   └── Profile.kt                  # Modelos de datos del perfil
│   ├── screen/                         # Pantallas completas
│   │   ├── ProfileScreen.kt            # Vista de perfil y métricas
│   │   ├── EditProfileScreen.kt        # Formulario de edición
│   │   └── WeightTrakingScreen.kt      # Seguimiento de peso e IMC
│   └── theme/                          # Sistema de diseño
│       ├── Color.kt                    # Paleta de colores (Modos claro/oscuro)
│       ├── Theme.kt                    # Configuración de MaterialTheme
│       └── Type.kt                     # Configuración tipográfica
└── utils/
    └── CalculadoraIMC.kt               # Lógica de cálculo matemático del IMC
```

---

## Requisitos y Configuración

### Requisitos previos
- **Android Studio** Hedgehog / Iguana / Ladybug o superior.
- **JDK:** Java 17 o Java 21 configurado en Android Studio.
- **Android SDK:**
  - `minSdk`: 24 (Android 7.0 Nougat)
  - `targetSdk` / `compileSdk`: 35+ (Android 15)

### Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/mrcsjalca/Fitness-App.git
   cd Fitness-App
   ```

2. **Abrir en Android Studio:**
   - Selecciona `File > Open...` y elige la carpeta del proyecto.
   - Espera a que Gradle sincronice las dependencias del proyecto.

3. **Compilar desde la terminal (opcional):**
   ```bash
   # En Windows PowerShell:
   .\gradlew.bat assembleDebug

   # En macOS / Linux:
   ./gradlew assembleDebug
   ```

4. **Ejecutar la app:**
   - Selecciona un dispositivo físico con depuración USB o un emulador Android (AVD) y presiona **Run** (`Shift + F10`).

---

## 🧪 Pruebas Unitarias

Para ejecutar los tests unitarios automatizados:

```bash
# Windows:
.\gradlew.bat testDebugUnitTest

# macOS / Linux:
./gradlew testDebugUnitTest
```

---

## Autor

- **Marcos Jalca**
- **Institución:** INS Baix Camp (Reus)
- **Repositorio:** [mrcsjalca/Fitness-App](https://github.com/mrcsjalca/Fitness-App)
