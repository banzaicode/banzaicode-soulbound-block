FROM openjdk:21-jdk-slim

# Instalar herramientas básicas
RUN apt-get update && apt-get install -y wget unzip git nano

# Instalar Gradle 8.4
RUN wget https://services.gradle.org/distributions/gradle-8.4-bin.zip -P /tmp && \
    unzip -d /opt /tmp/gradle-8.4-bin.zip && \
    mv /opt/gradle-8.4 /opt/gradle

ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

# Definir directorio de trabajo dentro del container
WORKDIR /workspace
