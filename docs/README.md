# Guía rápida para empezar

Esta sección del tutorial explica cómo configurar el entorno, compilar el mod y añadirlo a Minecraft.

## 1. Preparar el DevContainer

1. Instala [Visual Studio Code](https://code.visualstudio.com/).
2. Abre este repositorio en VS Code y elige **Reopen in Container**.
3. El contenedor se construirá con Java 17 y Gradle listos para usar.

Cuando el contenedor esté listo verás la carpeta del proyecto abierta con todas las dependencias resueltas.

## 2. Compilar el mod

Dentro del DevContainer abre una terminal y ejecuta:

```bash
./gradlew build
```

Al finalizar se generará un archivo `.jar` en la carpeta `dist/`. Este es el mod listo para usar.

## 3. Instalar en Minecraft

1. Descarga e instala Forge 1.20.1 en tu cliente o servidor.
2. Copia el `.jar` que está en `dist/` dentro de la carpeta `mods/` de tu instalación de Minecraft.
3. Inicia el juego o el servidor y el bloque **Soulbound** estará disponible.

¡Con eso ya puedes probar tu mod!
