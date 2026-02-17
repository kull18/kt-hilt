package com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.mapper

import com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.model.JsonPlaceHolderDTO
import com.alilopez.demo.features.jsonplaceholder.domain.entities.JsonPlaceHolder

fun JsonPlaceHolderDTO.toDomain(): JsonPlaceHolder {
    return JsonPlaceHolder(
       userId = this.userId,
        id = this.id,
        title =  this.title,
        body = this.body
    )
}