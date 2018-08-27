package com.pendorbound.openspource.web

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.Page

class WicketApplication : WebApplication() {
  override fun getHomePage(): Class<out Page>? {
    return HomePage::class.java
  }

  override fun init(): Unit {
    super.init()

    // add your configuration here
  }
}