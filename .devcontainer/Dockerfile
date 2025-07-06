FROM openjdk:17-jdk-slim

# Instalar herramientas básicas
RUN apt-get update && apt-get install -y wget unzip git nano

# Instalar Gradle 7.6
RUN wget https://services.gradle.org/distributions/gradle-7.6-bin.zip -P /tmp && \
    unzip -d /opt /tmp/gradle-7.6-bin.zip && \
    mv /opt/gradle-7.6 /opt/gradle

ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

# Definir directorio de trabajo dentro del container
WORKDIR /workspace
