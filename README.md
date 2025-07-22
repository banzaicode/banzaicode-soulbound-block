# Soulbound Block Mod

Este es mi mod de Minecraft creado en Forge 1.21.8. Añade el bloque "Soulbound Block", el cual solo puede ser destruido por quien lo colocó.
Para más detalles sobre el entorno y la compilación revisa la [guía completa](docs/README.md).

## Requisitos

- Java 21
- Gradle 7.6
- Servidor de Minecraft 1.21.8 con Forge 58.0.0

## ¿Cómo clonar el repositorio?

```bash
git clone https://github.com/banzaicode/banzaicode-soulbound-block.git
cd banzaicode-soulbound-block
```

## Abrir en VS Code con DevContainer

Con VS Code instalado, abre la carpeta del repositorio y selecciona **Reopen in Container** para iniciar el DevContainer provisto. Allí ya tendrás Java 21 y Gradle configurados.

## Compilar el mod

Dentro del contenedor ejecuta:

```bash
./gradlew build
```

El artefacto final se genera en `dist/`. Copia el `.jar` resultante al directorio `mods` de tu servidor de Minecraft.

## Pruebas rápidas en el DevContainer

Para realizar pruebas locales rápidas, usa el DevContainer: compila con el comando anterior y luego prueba el jar en un entorno de servidor local o cliente que tenga Forge 1.21.8.

## Uso en servidor propio

Este mod requiere un servidor de Minecraft 1.21.8 con Forge 58.0.0 y Java 21.

1. Descarga la versión del servidor de Forge para 1.21.8 (por ejemplo `forge-1.21.8-58.0.0`).
2. Copia el `.jar` generado en `dist/` dentro de la carpeta `mods/` del servidor.
3. Inicia el servidor con:

```bash
java -jar forge-1.21.8-58.0.0.jar nogui
```

## Solución de problemas

- **Versión incorrecta de Forge**: asegúrate de usar la versión 1.21.8 de Forge (58.0.0). Si utilizas otra versión el mod puede no cargar. Descarga la versión adecuada desde el sitio oficial de Forge e instálala nuevamente.
- **No estás usando Java 21**: la compilación y ejecución requieren Java 21. Instala JDK 21 o abre el proyecto en el DevContainer donde ya está incluido.
- **Gradle ejecutado fuera del DevContainer**: si corres `./gradlew` fuera del contenedor puedes tener dependencias faltantes o la versión de Java incorrecta. Abre el repositorio con **Reopen in Container** y ejecuta los comandos allí.

