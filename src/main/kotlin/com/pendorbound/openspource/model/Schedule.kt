package com.pendorbound.openspource.model

import java.time.LocalDateTime

/**
 * A schedule board.
 * @author pendor
 */ 
class Schedule(val name: String, var locations: Array<Location>, var startTime: LocalDateTime, var endTime: LocalDateTime) {
	
}