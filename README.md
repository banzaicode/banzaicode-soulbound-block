# Soulbound Block Mod

Este es mi mod de Minecraft creado en Forge 1.20.1. Añade el bloque "Soulbound Block", el cual solo puede ser destruido por quien lo colocó.

## Requisitos

- Java 17
- Gradle 7.6

## ¿Cómo clonar el repositorio?

```bash
git clone https://github.com/banzaicode/banzaicode-soulbound-block.git
cd banzaicode-soulbound-block
```

## Abrir en VS Code con DevContainer

Con VS Code instalado, abre la carpeta del repositorio y selecciona **Reopen in Container** para iniciar el DevContainer provisto. Allí ya tendrás Java 17 y Gradle configurados.

## Compilar el mod

Dentro del contenedor ejecuta:

```bash
./gradlew build
```

El artefacto final se genera en `build/libs/`. Copia el `.jar` resultante al directorio `mods` de tu servidor de Minecraft.

## Pruebas rápidas en el DevContainer

Para realizar pruebas locales rápidas, usa el DevContainer: compila con el comando anterior y luego prueba el jar en un entorno de servidor local o cliente que tenga Forge 1.20.1.
