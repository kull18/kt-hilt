package com.kull18.cinamefilms.features.movies.data.datasources.model

data class MoviesResponse(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)

data class MovieDto(
    val id: Int,
    val title: String,
    val original_title: String,
    val overview: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int,
    val popularity: Double,
    val adult: Boolean,
    val video: Boolean,
    val original_language: String,
    val genre_ids: List<Int>
)
