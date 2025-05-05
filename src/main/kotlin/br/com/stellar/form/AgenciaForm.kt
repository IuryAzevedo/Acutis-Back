package br.com.stellar.form

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import kotlinx.serialization.Serializable

@Serializable
data class AgenciaForm(
    @field:NotNull(message = "Informe o ID do banco.") val bancoId: Long,
    @field:NotBlank(message = "Informe o nome da agência.") val nome: String,
    @field:NotBlank(message = "Informe o endereço da agência.") val endereco: String
)
