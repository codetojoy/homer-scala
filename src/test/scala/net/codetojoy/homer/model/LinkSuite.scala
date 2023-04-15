package net.codetojoy.homer.model

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LinkSuite extends AnyFunSuite {
    test("canary") {
        // test
        val link = new Link("https://www.cbc.ca", "CBC")

        assert(link.href == "https://www.cbc.ca")
    }
}
