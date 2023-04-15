
package net.codetojoy.homer

import net.codetojoy.homer.model._
import play.twirl.api._

object Main extends App {
    val model: HomerModel = new HomerModel()
    model.build(null)
    val content: Html = html.links(model = model)
    println(content)
    println("Ready.")
}
