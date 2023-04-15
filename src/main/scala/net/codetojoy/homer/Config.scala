package net.codetojoy.homer

import java.io.FileInputStream
import java.util.Properties

class Config(val configFile: String) {
    val properties = new Properties()
    properties.load(new FileInputStream(configFile))
    val jQueryPath = properties.getProperty("jquery.path")
    val jQueryUiPath = properties.getProperty("jquery.ui.path")
    val jQueryUiCssPath = properties.getProperty("jquery.ui.css.path")
    val templateFile = properties.getProperty("template.file")
}


