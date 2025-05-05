package br.com.stellar.model

import br.com.stellar.serialization.BigDecimalJson
import kotlinx.serialization.Serializable

@Serializable
data class ContaDTO(
    val id: Long?,
    val agenciaId: Long,
    val usuarioId: Long,
    val tipoConta: String,
    val saldo: BigDecimalJson,
    val cartaoCredito: Boolean? = null,
    val saldoCartaoCredito: BigDecimalJson? = null,
    val possuiLis: Boolean? = null,
    val saldoLis: BigDecimalJson? = null
)
