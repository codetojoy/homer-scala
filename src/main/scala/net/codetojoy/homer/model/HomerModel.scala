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
        var currentLinks = new ListBuffer[Link]()
        var currentLinkGroups = new ListBuffer[LinkGroup]()
        var header = ""
        val lines = readFile(inFilename)

        for (line <- lines) {
            val tokens = line.split(",")
            val numTokens = tokens.length

            if (numTokens == 1) {
                val isFirst = (header.isEmpty())
                if (!isFirst) {
                    val linkGroup = LinkGroup(header, currentLinks.toList)
                    currentLinkGroups += linkGroup
                }
                header = tokens(0)
                currentLinks = new ListBuffer[Link]()
            } else if (numTokens == 2) {
                var name = tokens(0)
                var href = tokens(1)
                val link = new Link(href, name)
                currentLinks += link
            } else {
                throw new IllegalStateException("internal error: # tokens: " + numTokens)
            }
        }
        val linkGroup = LinkGroup(header, currentLinks.toList)
        currentLinkGroups += linkGroup
        linkGroups = currentLinkGroups.toList
    }
}
