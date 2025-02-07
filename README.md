## homer-scala

An example of Homer (website bookmarks) in Scala 2.

* Notes:
    - uses Twirl

### Usage

* edit `links.txt` with websites
* `./refresh.sh`
* open `./index.html`
* or `./scanner.sh` will act as a service and re-gen `index.html` on change to `links.txt`

### Todo

* use Scala 3
* enable unit-tests! I can't get Scala 3 test libs to work due to jar hell with Twirl
* `HomerModel.scala` is messy 

### env

```
$ java --version
openjdk 11.0.19 2023-04-18 LTS
$ scala --version
sbScala code runner version 3.3.1 -- Copyright 2002-2023, LAMP/EPFL
t$ sbt --version
sbt version in this project: 1.9.6
sbt script version: 1.7.3
```
