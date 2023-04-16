
package net.codetojoy.homer

import net.codetojoy.homer.model._

import java.io._
import play.twirl.api._

object Main extends App {
    if (args.length == 0) {
        println("requires links.txt file")
    }
    val inFilename = args(0)
    val outFilename = args(1)
    val model: HomerModel = new HomerModel()
    model.build(inFilename)
    val content: Html = html.links(model = model)
    writeFile(outFilename, content.body)
    println("Ready.")

    def writeFile(filename: String, body: String): Unit = {
        val file = new File(filename)
        val bw = new BufferedWriter(new FileWriter(file))
        bw.write(body)
        bw.close()
    }
}
