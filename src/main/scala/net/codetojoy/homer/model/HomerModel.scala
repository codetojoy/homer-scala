package net.codetojoy.homer.model

import scala.collection.mutable.ListBuffer

class HomerModel(var linksList: List[Links] = List()) {
    def readFile(filename: String): Seq[String] = {
        val bufferedSource = io.Source.fromFile(filename)
        val lines = (for (line <- bufferedSource.getLines()) yield line).toList.filter(!_.trim().isEmpty()).map(_.trim())
        bufferedSource.close
        lines
    }

    def build(inFilename: String): Unit = {
        var currentLinks = new ListBuffer[Link]()
        var currentLinkList = new ListBuffer[Links]()
        var header = ""
        val lines = readFile(inFilename)

        for (line <- lines) {
            val tokens = line.split(",")
            val numTokens = tokens.length

            if (numTokens == 1) {
                val isFirst = (header.isEmpty())
                if (!isFirst) {
                    val newLinks = Links(header, currentLinks.toList)
                    currentLinkList += newLinks
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
        val newLinks = Links(header, currentLinks.toList)
        currentLinkList += newLinks
        linksList = currentLinkList.toList
    }
}
