package com.pendorbound.openspource.model

import java.time.LocalDateTime

/**
 * A class session.
 * @author pendor
 */
data class Session(
		var name: String,
		var location: Location,
		var participants: Array<Participant>
) {
	var startTime: LocalDateTime? = null
	var isEnded: Boolean = false
	var isSkipped: Boolean = false
}