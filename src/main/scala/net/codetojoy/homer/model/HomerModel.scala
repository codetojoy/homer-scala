package net.codetojoy.homer.model

import java.io.File

class HomerModel(var links: Links = new Links("", List())) {

    def build(file: File): Unit = {
        val link1 = new Link("https://peidevs.github.io", "Home")
        val link2 = new Link("https://github.com/peidevs/Event_Resources/blob/master/MeetUps.md", "Announcements")
        links = new Links("PEI Devs", List(link1, link2))
    }
}
