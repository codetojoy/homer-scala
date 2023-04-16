package net.codetojoy.homer.model

// import java.io._
// import java.nio._
// import java.nio.file._
import scala.collection.mutable.ListBuffer

class HomerModel(var linksList: List[Links] = List()) {
    def readFile(filename: String): Seq[String] = {
        val bufferedSource = io.Source.fromFile(filename)
        val lines = (for (line <- bufferedSource.getLines()) yield line).toList.filter(!_.trim().isEmpty())
        bufferedSource.close
        lines
    }

    def build(inFilename: String): Unit = {
        var currentLinks = new ListBuffer[Link]()
        var currentLinkList = new ListBuffer[Links]()
        var header = ""
        var isFirst = true
        val lines = readFile(inFilename)

        for (line <- lines) {
            val tokens = line.trim().split(",")
            val numTokens = tokens.length
            if (numTokens == 1) {
                if (!isFirst) {
                    val newLinks = Links(header, currentLinks.toList)
                    currentLinkList += newLinks
                }
                isFirst = false
                header = tokens(0)
                currentLinks = new ListBuffer[Link]()
                // currentLinks = Links(header, List())
                // linksList.add(currentLinks)
            } else if (numTokens == 2) {
                val link = new Link(tokens(0), tokens(1))
                currentLinks += link
            } else {
                throw new IllegalStateException("internal error: # tokens: " + numTokens)
            }
        }
        val newLinks = Links(header, currentLinks.toList)
        currentLinkList += newLinks
        linksList = currentLinkList.toList
        /*
        val link1 = new Link("https://peidevs.github.io", "Home")
        val link2 = new Link("https://github.com/peidevs/Event_Resources/blob/master/MeetUps.md", "Announcements")
        linksList = List(new Links("PEI Devs", List(link1, link2)))
        */
    }
}
