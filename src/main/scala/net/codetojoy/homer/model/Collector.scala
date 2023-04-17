package net.codetojoy.homer.model

import scala.collection.mutable.ListBuffer

class Collector(var currentLinks: ListBuffer[Link] = new ListBuffer[Link](),
             var currentLinkGroups: ListBuffer[LinkGroup] = new ListBuffer[LinkGroup]()) {
    def newLinkGroup(header: String): Unit = {
        // guard clause
        if (header.isEmpty()) {
            return
        }
        // capture current group
        val linkGroup = LinkGroup(header, currentLinks.toList)
        currentLinkGroups += linkGroup
        // prepare for next group
        currentLinks = new ListBuffer[Link]()
    }

    def newLink(href: String, name: String): Unit = {
        val link = new Link(href, name)
        currentLinks += link
    }
}
