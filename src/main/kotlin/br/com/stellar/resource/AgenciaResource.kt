package br.com.stellar.resource

import br.com.stellar.form.AgenciaForm
import br.com.stellar.service.AgenciaService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/agencia")
class AgenciaResource(@Inject var agenciaService: AgenciaService) {

    @POST
    @Path("/nova")
    fun create(form: AgenciaForm) = agenciaService.criarAgencia(form)

    @GET
    @Path("/all")
    fun all() = agenciaService.listAgencias()
}
