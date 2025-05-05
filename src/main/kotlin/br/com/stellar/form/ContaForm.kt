package br.com.stellar.form

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import br.com.stellar.serialization.BigDecimalJson

@Serializable
data class ContaForm(
    @field:NotNull(message = "Informe o ID da agência.") val agenciaId: Long,
    @field:NotNull(message = "Informe o ID do usuário.") val usuarioId: Long,
    @field:NotBlank(message = "Informe o tipo de conta.") val tipoConta: String,
    val saldo: BigDecimalJson = BigDecimal.ZERO,
    val cartaoCredito: Boolean? = null,
    val saldoCartaoCredito: BigDecimalJson? = null,
    val possuiLis: Boolean? = null,
    val saldoLis: BigDecimalJson? = null
)
