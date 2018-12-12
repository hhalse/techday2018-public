package no.finn.techday2018.task10json

/**
 * This class represents our results. You'll need to find a way to tell
 * Gson which field in the JSON file corresponds to which object property, either
 * by modifying this class or how you create your Gson object.
 */
data class AdItem(
    val imageUrl: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageOverlay: String,
    val title: String
)