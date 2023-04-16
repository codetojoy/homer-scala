## homer-scala

An example of Homer (website bookmarks) in Scala 2.

* Notes:
    - uses Twirl

### Usage

* edit `links.txt` with websites
* `./refresh.sh`
* open `./index.html`

### Todo

* use Scala 3
* enable unit-tests! I can't get Scala 3 test libs to work due to jar hell with Twirl
* `HomerModel.scala` is messy 

### env

```
$ java --version
openjdk 11.0.2 2019-01-15
$ scala --version
Scala code runner version 3.2.2
$ sbt --version
sbt version in this project: 1.5.4
sbt script version: 1.7.3
```
