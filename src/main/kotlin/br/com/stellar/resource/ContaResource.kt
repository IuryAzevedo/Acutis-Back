package br.com.stellar.resource

import br.com.stellar.form.ContaForm
import br.com.stellar.service.ContaService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/conta")
class ContaResource(@Inject var contaService: ContaService) {

    @POST
    @Path("/nova")
    fun create(form: ContaForm) = contaService.criarConta(form)

    @GET
    @Path("/all")
    fun all() = contaService.listContas()
}
