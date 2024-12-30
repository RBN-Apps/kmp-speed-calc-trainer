package de.rbn.speedcalctrainer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform