# Proyecto de Películas - Aplicación Android

Este es un proyecto de Android que consume una API de películas para mostrar una lista de películas en la aplicación. El proyecto está desarrollado en Android Studio utilizando Java/Kotlin (dependiendo del lenguaje que utilices), y hace uso de Retrofit para consumir la API.

## Descripción

La aplicación se conecta a una API de películas (como [The Movie DB API](https://www.themoviedb.org/)) para obtener información sobre las películas, como títulos, imágenes y descripciones, y luego muestra esa información en una interfaz amigable para el usuario. El proyecto incluye funcionalidades como la visualización de una lista de películas, detalles de cada película, y la capacidad de ver imágenes de las portadas.

## Características

- Consume una API de películas (The Movie DB o cualquier otra API similar).
- Muestra una lista de películas.
- Detalles de cada película con información adicional como la sinopsis, año de estreno, y calificación.
- Interfaz de usuario interactiva y fácil de usar.
- Uso de Retrofit para manejar las peticiones a la API.

## Requisitos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes elementos:

- [Android Studio](https://developer.android.com/studio) (recomendado la última versión).
- [JDK 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) para la ejecución de aplicaciones Android.
- Acceso a internet para hacer peticiones a la API.

## Instalación

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone https://github.com/joabvb/Practica2.git
2. Abre el proyecto en Android Studio.
3. Asegúrate de que tienes configurados los permisos necesarios en el archivo AndroidManifest.xml para el acceso a internet:
- <uses-permission android:name="android.permission.INTERNET"/>
4. Instala las dependencias del proyecto. Android Studio se encargará de hacerlo automáticamente cuando lo abras por primera vez.
5. Configura las claves de la API en los archivos correspondientes (por ejemplo, strings.xml o variables de entorno). Si usas The Movie DB, necesitarás una API key.
6. Ejecuta el proyecto en un emulador o dispositivo Android.

## Dependencias
Este proyecto utiliza las siguientes dependencias para facilitar el consumo de la API y la creación de la interfaz de usuario:
- Retrofit - Librería para manejar las peticiones HTTP.
- Gson - Para convertir los datos JSON de la API a objetos Java.
- Glide - Para cargar imágenes de forma eficiente en la UI.
- RecyclerView - Para mostrar la lista de películas.

## Dependencias en build.gradle:
dependencies {
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
}
