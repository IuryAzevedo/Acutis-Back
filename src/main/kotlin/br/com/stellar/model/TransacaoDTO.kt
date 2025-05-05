package br.com.stellar.model

import br.com.stellar.serialization.BigDecimalJson
import br.com.stellar.serialization.LocalDateTimeJson
import kotlinx.serialization.Serializable

@Serializable
data class TransacaoDTO(
    val id: Long,
    val contaOrigemId: Long,
    val contaDestinoId: Long,
    val valor: BigDecimalJson,
    val dataHora: LocalDateTimeJson
)
