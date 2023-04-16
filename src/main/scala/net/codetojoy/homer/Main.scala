
package net.codetojoy.homer

import net.codetojoy.homer.model._
import play.twirl.api._

object Main extends App {
    if (args.length == 0) {
        println("requires links.txt file")
    }
    val filename = args(0)
    val model: HomerModel = new HomerModel()
    model.build(filename)
    val content: Html = html.links(model = model)
    println(content)
    println("Ready.")
}
