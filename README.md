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

```ssh latitude```

```docker stop spigot```

```docker start spigot```

### Create pull request

```git checkout -b <pull request name>``` create branch

```git add . -p``` add changes

```git commit -m <commit name>``` create commit

```git push``` push to server and follow the output twice

Given url copy to browser and create pull request, after merge

```git checkout master```

```git pull```

```git tag -a <your number> -m "your message"```

### Apply new plugin

Get plugin link from https://github.com/VincentZocker/spigot-plugin/releases

```wget https://github.com/VincentZocker/spigot-plugin/releases/download/1.2.0/<Your NetherScrap-XXXXX.jar> -P ~/dataSpigot/plugins/```
  
look for current plugin

```ls ~/dataSpigot/plugins/```

remove old plugin

```rm ~/dataSpigot/plugins/<Your OLD NetherScrap-XXXXX.jar>```

### Show docker log

`docker logs -f spigot`
