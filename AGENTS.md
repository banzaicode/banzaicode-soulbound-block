# AGENTS.md

## 🧭 Propósito del Repositorio

Este repositorio es un tutorial práctico para aprender a desarrollar mods en Java para Minecraft Java Edition. Está orientado a principiantes y enseña cómo agregar un nuevo bloque personalizado al juego, con una funcionalidad única.

---

## 🤖 Objetivos de Codex

Codex debe facilitar el desarrollo del tutorial y ayudar a los usuarios a avanzar paso a paso. Sus responsabilidades son:

- Mantener el `README.md` actualizado con cada nuevo paso del tutorial.
- Generar y organizar el código fuente en Java del mod.
- Comentar el código con explicaciones claras y pedagógicas.
- Proponer mejoras didácticas para que el tutorial sea más accesible.
- Sugerir estructura de carpetas adecuada para proyectos de Minecraft.
- Generar diagramas o tablas explicativas si ayudan al entendimiento.
- Asegurar que se incluyan instrucciones para compilar y probar el mod.
- Identificar errores comunes de principiantes y alertarlos en el tutorial.
- **Crear y mantener un entorno de desarrollo aislado mediante un `devcontainer` compatible con Visual Studio Code.**

---

## 🗂️ Estructura del Proyecto

- `/src/main/java`: Código fuente del mod en Java.
- `/src/main/resources`: Archivos de recursos (texturas, JSONs, lang files).
- `/docs`: Documentación paso a paso del tutorial.
- `/build.gradle` y `/settings.gradle`: Configuración del proyecto Gradle.
- `/.devcontainer/`: Archivos de definición del entorno de desarrollo en contenedor.
- `/README.md`: Guía central del tutorial (debe crecer paso a paso).

---

## 🧑‍💻 Directrices de Desarrollo

- Código simple, claro y bien comentado.
- Usar nombres de clases descriptivos (ej: `CustomBlock.java`).
- Mantener el tutorial simple, con una secuencia lógica para principiantes.
- Usar terminología comprensible para personas sin experiencia previa en Minecraft modding.
- Seguir buenas prácticas en Gradle y estructura de recursos.

---

## 🧪 Testing

- No se requieren pruebas automatizadas.
- Codex puede sugerir pasos para probar manualmente el mod en el entorno de Minecraft.
- Incluir indicaciones sobre cómo detectar errores comunes.

---

## 🔁 Automatización esperada

- Crear un entorno de desarrollo basado en `devcontainer`:
  - Imagen base con Java JDK 17.
  - Soporte para Gradle.
  - Configuración para abrir automáticamente el proyecto en VS Code.
- Generar artefacto `.jar` en carpeta `dist/` con `./gradlew build`.

---

## 🔗 Referencias externas

- [Documentación de Minecraft Forge](https://mcforge.readthedocs.io/en/latest/)
- [Documentación de Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [Documentación de Dev Containers de VS Code](https://code.visualstudio.com/docs/devcontainers/containers)

---

## 📚 Glosario

- **Mod**: Modificación del juego original, en este caso Minecraft Java Edition.
- **Forge**: API/framework que permite crear mods para Minecraft.
- **Bloque**: Elemento cúbico del mundo de Minecraft (como piedra, tierra, etc.).
- **Custom Block**: Bloque personalizado que no existe en el juego base.
- **Recursos**: Archivos necesarios como texturas e identificadores de idioma.
- **Devcontainer**: Contenedor de desarrollo que define un entorno reproducible dentro de VS Code.
