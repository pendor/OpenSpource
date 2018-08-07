package com.pendorbound.openspource.model

/**
 * A participant in a *Session*.  May be the presenter or a named assistant, etc. on the card.
 * @author pendor
 */
data class Participant(val name: String, val description: String, val contact: String, val contactType: ContactType, val isContactPublic: Boolean) {
}