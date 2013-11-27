# MCCV Common Library

Folgende Repository enthält eine Basis-Library, die für MCCV-Plugin genutzt
wird. Mit ihr können einige ständig anfallenden Aufgaben für "normale"
Java-Software, Bukkit- und BungeeCord-Plugins erledigt werden.

## Komponenten

Die Aufteilung erfolgt in Maven-Modulen:

* **common-java:** Tools für allgemeine Java-Aufgaben
* **common-bukkit:** Tools für allgemeine Aufgaben, die für Bukkit-Plugins
  anfallen
* **common-bungeecord:** Tools für allgemeine Aufgaben, die für
  BungeeCord-Plugins anfallen

## Bauen

Um die Library selbst testen oder verwenden zu können, muss diese selbst gebaut
werden. Dazu wird mindestens Apache Maven 3 benötigt. Um das Projekt zu bauen,
ruft man Maven wie folgt auf auf:

```
mvn clean install package
```

* *clean* leert gegebenenfalls unbeabsichtigt zurück gebliebende Reste des
  letzten Builds
* *install* installiert alle drei Komponenten in die lokale Maven-Repository,
  um sie später problemlos als Abhängigkeit einfügen zu können
* *package* packt die drei Komponenten jeweils in eine .jar-Datei

Sobald der Build durchgelaufen ist, findet sich unter `common-bukkit/target`
das Bukkit-Plugin und unter `common-bungeecord/target` das BungeeCord-Plugin.

## Lizenz

Siehe LICENSE.md