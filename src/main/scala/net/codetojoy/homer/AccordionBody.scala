
package net.codetojoy.homer

import net.codetojoy.homer.model.Links

class AccordionBody {
    def build(links: Links):String =
        val builder = new StringBuilder()
        val header = links.header
        builder.append(s"<h3><a href='#'>$header</a></h3>\n")
        builder.append("<div>\n")
        for (link <- links.links) {
            val href = link.href
            val name = link.name
            builder.append(s"<a class='link' href='$href'>$name</a> <br/>\n")
        }
        builder.append("</div>\n")
        return builder.toString()
    end build
}
