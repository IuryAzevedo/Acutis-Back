package br.com.stellar.resource

import br.com.stellar.form.UsuarioForm
import br.com.stellar.service.UsuarioService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/usuario")
class UsuarioResource(@Inject var usuarioService: UsuarioService) {

    @POST
    @Path("/novo")
    fun create(form: UsuarioForm) = usuarioService.criarUsuario(form)

    @GET
    @Path("/all")
    fun all() = usuarioService.listUsuarios()
}
