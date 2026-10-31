# FitnessApp

Aplicación Android de fitness desarrollada con **Kotlin** y **Jetpack Compose**. Esta primera fase permite consultar y modificar el perfil de un usuario con datos locales en memoria (sin Firebase).

## Pantallas

### ProfileScreen

Muestra la foto de perfil, el nombre, el correo electrónico, los datos físicos (edad, género, peso y altura), el objetivo seleccionado y el nivel de actividad. Desde el icono de editar se accede a la pantalla de edición.

<img width="401" height="852" alt="image" src="https://github.com/user-attachments/assets/b9ca8dfe-2b2d-427c-8cd2-91d07817f870" />

### EditProfileScreen

Permite modificar el nombre, el correo, la fecha de nacimiento, el objetivo, el nivel de actividad, la altura y el peso. Incluye los botones **Guardar canvis** y **Cancel·lar**.

<img width="390" height="853" alt="image" src="https://github.com/user-attachments/assets/934dc703-9311-4049-b787-c8a2b3b6e77c" />

## Funcionamiento

- `FitnessApp` (en `MainActivity`) guarda los datos del perfil y decide qué pantalla mostrar con la variable `editant`.
- Al pulsar **Guardar canvis**, los datos nuevos se copian al estado de `FitnessApp` y se vuelve al perfil.
- Al pulsar **Cancel·lar**, se vuelve al perfil sin cambiar nada, porque la pantalla de edición trabaja con copias locales de los datos.

## Estructura del proyecto

```
org.insbaixcamp.fitnessapp
├── MainActivity.kt                 # FitnessApp: estado y navegación
├── ui
│   ├── screen
│   │   ├── ProfileScreen.kt        # Pantalla de perfil
│   │   ├── EditProfileScreen.kt    # Pantalla de edición
│   │   └── MenuDesplegable.kt      # Menú desplegable reutilizable
│   ├── components
│   │   └── OutlinedDatePickerField.kt  # Selector de fecha
│   └── theme                       # Tema de la app
```

## Componentes de Jetpack Compose utilizados

`Column`, `Row`, `Card`, `Text`, `Image`, `Icon`, `IconButton`, `Button`, `OutlinedButton`, `OutlinedTextField`, `ExposedDropdownMenuBox`, `DatePickerDialog`, `rememberSaveable` y `mutableStateOf`.

## Comprobaciones

- [x] Abrir la aplicación y ver los datos iniciales.
- [x] Editar nombre, peso y objetivo, y pulsar **Guardar canvis** para ver los cambios en el perfil.
- [x] Editar un campo y pulsar **Cancel·lar** para comprobar que se mantiene el valor anterior.

## Cómo ejecutarlo

1. Clona el repositorio.
2. Ábrelo con Android Studio.
3. Espera a que Gradle sincronice el proyecto.
4. Ejecuta la app en un emulador o en un dispositivo físico.

## Autor

Marcos Jalca · [GitHub](https://github.com/mrcsjalca) · CFGS DAM, INS Baix Camp (Reus)
