package com.pendorbound.openspource.model

import java.time.LocalDateTime
import org.jupnp.binding.annotations.UpnpService
import org.jupnp.binding.annotations.UpnpServiceId
import org.jupnp.binding.annotations.UpnpServiceType

/**
 * A schedule board.
 * @author pendor
 */
@UpnpService(
        serviceId = UpnpServiceId("OpenSpource_Schedule"),
        serviceType = UpnpServiceType(
                value="Schedule",
                version = 1)
)
class Schedule(val name: String, val locations: Array<Location>, var startTime: LocalDateTime, var endTime: LocalDateTime) {
  
  val table: MutableMap<Location, MutableList<Session>> = mutableMapOf()
  
  /**
   * Insert a session for a location, possibly delaying it a certain
   * number of slots behind existing sessions.
   */ 
  fun addSession(sess: Session, at: Location, delay: Int = 1) {
    var locList: MutableList<Session>
    if(table.containsKey(at)) {
      locList = table.get(at)!!
      
      if(delay <= 0) {
        locList.add(0, sess)
      } else if(locList.size > delay) {
        locList.add(delay, sess)
      } else {      
        locList.add(sess)
      }
    } else {
      locList = mutableListOf(sess)
      table.put(at, locList)
    }
  }
  
  fun moveSession(sess: Session, to: Location) {
    var delay = deleteSession(sess)
    if(delay < 0) {
      delay = 1
    }
    
    addSession(sess, to, delay)
  }
  
  fun deleteSession(sess: Session) : Int {
    locations.forEach {
      val locList = table.getOrDefault(it, mutableListOf())
      val idx = locList.indexOf(sess)
      if(idx > -1) {
        locList.removeAt(idx)
        return idx
      }
    }
    return -1
  }
}