# MCCV Common Library

Folgende Repository enth�lt eine Basis-Library, die f�r MCCV-Plugin genutzt
wird. Mit ihr k�nnen einige st�ndig anfallenden Aufgaben f�r "normale"
Java-Software, Bukkit- und BungeeCord-Plugins erledigt werden.

## Komponenten

Die Aufteilung erfolgt in Maven-Modulen:

* **common-java:** Tools f�r allgemeine Java-Aufgaben
* **common-bukkit:** Tools f�r allgemeine Aufgaben, die f�r Bukkit-Plugins
  anfallen
* **common-bungeecord:** Tools f�r allgemeine Aufgaben, die f�r
  BungeeCord-Plugins anfallen

## Bauen

Um die Library selbst testen oder verwenden zu k�nnen, muss diese selbst gebaut
werden. Dazu wird mindestens Apache Maven 3 ben�tigt. Um das Projekt zu bauen,
ruft man Maven wie folgt auf auf:

```
mvn clean install package
```

* *clean* leert gegebenenfalls unbeabsichtigt zur�ck gebliebende Reste des
  letzten Builds
* *install* installiert alle drei Komponenten in die lokale Maven-Repository,
  um sie sp�ter problemlos als Abh�ngigkeit einf�gen zu k�nnen
* *package* packt die drei Komponenten jeweils in eine .jar-Datei

Sobald der Build durchgelaufen ist, findet sich unter `common-bukkit/target`
das Bukkit-Plugin und unter `common-bungeecord/target` das BungeeCord-Plugin.

## Lizenz

Siehe LICENSE.md