package br.com.stellar.service

import br.com.stellar.entities.Usuario
import br.com.stellar.form.UsuarioForm
import br.com.stellar.model.UsuarioDTO
import jakarta.enterprise.context.ApplicationScoped
// import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional

@ApplicationScoped
class UsuarioService {

    @Transactional
    fun criarUsuario(form: UsuarioForm) = Usuario.create(form).persist()

    fun listUsuarios(): List<UsuarioDTO> =
        Usuario.findAll().list().map { UsuarioDTO(it.id,it.nome, it.email, it.usuario, it.endereco, it.senha) }

}
