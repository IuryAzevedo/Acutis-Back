package br.com.stellar.model

import kotlinx.serialization.Serializable

@Serializable
data class AgenciaDTO(
    val id: Long?,
    val nome: String,
    val endereco: String,
    val banco_id: Long,
    val ativo: Boolean
)
