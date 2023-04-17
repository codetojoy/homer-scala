package net.codetojoy.homer.model

import scala.collection.mutable.ListBuffer

class HomerModel(var linkGroups: List[LinkGroup] = List()) {
    // return non-empty lines, trimmed
    def readFile(filename: String): Seq[String] = {
        val bufferedSource = io.Source.fromFile(filename)
        val lines = (for (line <- bufferedSource.getLines()) yield line).toList.filter(!_.trim().isEmpty()).map(_.trim())
        bufferedSource.close
        lines
    }

    def build(inFilename: String): Unit = {
        val collector = new Collector()
        var header = ""
        val lines = readFile(inFilename)

        for (line <- lines) {
            val tokens = line.split(",")
            val numTokens = tokens.length

            if (numTokens == 1) {
                collector.newLinkGroup(header)
                header = tokens(0)
            } else if (numTokens == 2) {
                var name = tokens(0)
                var href = tokens(1)
                collector.newLink(href, name)
            } else {
                throw new IllegalStateException("internal error: # tokens: " + numTokens)
            }
        }
        collector.newLinkGroup(header)
        linkGroups = collector.currentLinkGroups.toList
    }
}
