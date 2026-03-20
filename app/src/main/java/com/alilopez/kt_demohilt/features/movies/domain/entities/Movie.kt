package com.kull18.cinamefilms.features.movies.domain.entities

data class Movie(
    val title: String,
    val overview: String,
    val poster_path: String?,
    val releaseDate: String,
    val rating: Double,
    val backdrop_path: String?,
    val voteCount: Int,
    val popularity: Double
)
