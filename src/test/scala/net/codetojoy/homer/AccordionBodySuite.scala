package net.codetojoy.homer

import net.codetojoy.homer.model._

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AccordionBodySuite extends AnyFunSuite {
    test("canary") {
        val expectedHtml = """
<h3><a href='#'>PEI Devs</a></h3>
<div>
<a class='link' href='https://peidevs.github.io'>Home</a> <br/>
<a class='link' href='https://github.com/peidevs/Event_Resources/blob/master/MeetUps.md'>Announcements</a> <br/>
</div>
"""
        val accordionBody = new AccordionBody()
        val link1 = new Link("https://peidevs.github.io", "Home")
        val link2 = new Link("https://github.com/peidevs/Event_Resources/blob/master/MeetUps.md", "Announcements")
        val links = new Links("PEI Devs", List(link1, link2))

        // test
        val actualHtml = accordionBody.build(links)

        assert(actualHtml == "hello")
    }
}
