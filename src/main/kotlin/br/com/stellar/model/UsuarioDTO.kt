package br.com.stellar.model

import kotlinx.serialization.Serializable



@Serializable
data class UsuarioDTO(
    val id: Long?,
    val nome: String,
    val email: String,
    val usuario: String,
    val senha: String,
    val endereco: String
)
