package br.com.stellar.form

import jakarta.validation.constraints.NotNull
import kotlinx.serialization.Serializable
import br.com.stellar.serialization.BigDecimalJson

@Serializable
data class TransacaoForm(
    @field:NotNull(message = "Informe a conta de origem.")
    val contaOrigemId: Long,

    @field:NotNull(message = "Informe a conta de destino.")
    val contaDestinoId: Long,

    @field:NotNull(message = "Informe o valor da transação.")
    val valor: BigDecimalJson
)
