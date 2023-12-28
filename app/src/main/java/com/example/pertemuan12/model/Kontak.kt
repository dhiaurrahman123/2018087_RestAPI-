package com.example.pertemuan12.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val nama : String,
    val nohp: String,
    ///@SerialName("email"),
    val email: String
)
