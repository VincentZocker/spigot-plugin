# Spigot plugin
Project for the Minecraft / Spigot Plugin based on Gradle

Creating Eclipse Project Files:

`./gradlew eclipse`

Creating IDEA Project Files:

`./gradlew idea`

Building Project:

`./gradlew build`

Starting embedded Minecraft/Spigot-Server and deploying plugin into it:

`./gradlew startDevServer`

### Server create
```
docker run -d \
-v /home/vincent/dataSpigot:/data \
-p 25565:25565 \
--restart unless-stopped \
--name spigot \
-e BUILD_FROM_SOURCE=false \
-e TYPE=SPIGOT \
-e EULA=TRUE itzg/minecraft-server:multiarch
```

### Server stop & start

```docker stop spigot```
```docker start spigot```
