package com.kull18.cinamefilms.features.movies.data.datasources.mapper

import com.kull18.cinamefilms.features.movies.data.datasources.model.MovieDto
import com.kull18.cinamefilms.features.movies.domain.entities.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        title = this.title,
        overview = this.overview,
        poster_path = this.poster_path,
        releaseDate = this.release_date,
        rating = this.vote_average,
        backdrop_path= this.backdrop_path,
        popularity = this.popularity,
        voteCount = this.vote_count,
    )
}