package com.hana897trx.pokeapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokeResponse (
    var count : Int,
    var next : String,
    var previus : String?,
    var results : List<PokeModel>
)