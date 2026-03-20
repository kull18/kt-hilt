package com.kull18.cinemafilms.core.data.utils

object ImageUtils {
    private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
    private const val POSTER_SIZE = "w500"
    private const val BACKDROP_SIZE = "w1280"

    fun getPosterUrl(posterPath: String?): String {
        return if (posterPath != null) {
            "$BASE_IMAGE_URL$POSTER_SIZE$posterPath"
        } else {
            "" // O una imagen placeholder
        }
    }

    fun getBackdropUrl(backdropPath: String?): String {
        return if (backdropPath != null) {
            "$BASE_IMAGE_URL$BACKDROP_SIZE$backdropPath"
        } else {
            ""
        }
    }
}