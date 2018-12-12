package no.finn.techday2018.task10json

import com.google.gson.annotations.SerializedName

data class AdItem(
    @SerializedName("image-url") val imageUrl: String,
    @SerializedName("image-width") val imageWidth: Int,
    @SerializedName("image-height") val imageHeight: Int,
    @SerializedName("image-overlay") val imageOverlay: String,
    @SerializedName("title") val title: String
)