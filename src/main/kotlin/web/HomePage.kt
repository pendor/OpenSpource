package com.pendorbound.openspource.web

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.apache.wicket.markup.html.basic.Label
import org.kwicket.wicket.core.markup.html.link.KLink
import org.kwicket.model.model
import com.pendorbound.openspource.cluster.Locator;

class HomePage(parameters: PageParameters) : WebPage(parameters) {
  init {
    add(KLink("btnStart", "Start".model(), {
      Locator.startBroadcast()
    }))
    
    add(KLink("btnStop", "Stop".model(), {
      Locator.stopBroadcast()
    }))

  }
}