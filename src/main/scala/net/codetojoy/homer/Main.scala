
package net.codetojoy.homer

object Main {
    def main(args: Array[String]): Unit =
        val linksFilename = args(0)
        val configFilename = args(1)
        // val link = new Link("abc", "def")
        // val links = new Links("header", List("item1"))
        val config = new Config(configFilename)
        println("TRACER value: " + config.jQueryPath)
        println("TRACER hello from main v5")
        println("Ready.")
}
