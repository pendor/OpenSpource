package com.pendorbound.openspource.web

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.apache.wicket.markup.html.basic.Label

class HomePage(parameters: PageParameters) : WebPage(parameters) {
  init {
    add(Label("version", application.frameworkSettings.version))
  }
}