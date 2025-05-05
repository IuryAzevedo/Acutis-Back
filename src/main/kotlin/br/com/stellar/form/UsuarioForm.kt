package br.com.stellar.form

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
// import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializable

@Serializable
data class UsuarioForm(
    @field:NotBlank(message = "Informe o nome.") val nome: String,
    @field:NotBlank(message = "Informe o e-mail.") @field:Email(message = "Informe um e-mail válido.") val email: String,
    @field:NotBlank(message = "Informe o nome de usuário.") val usuario: String,
    @field:NotBlank(message = "Informe a senha.") val senha: String,
    @field:NotBlank(message = "Informe o endereço.") val endereco: String
)
