package br.com.stellar.service

import br.com.stellar.entities.Agencia
import br.com.stellar.form.AgenciaForm
import br.com.stellar.model.AgenciaDTO
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException

@ApplicationScoped
class AgenciaService {

    @Transactional
    fun criarAgencia(form: AgenciaForm) = Agencia.create(form).persist()

    

    fun listAgencias(): List<AgenciaDTO> =
        Agencia.findAll().list().map { AgenciaDTO(it.id, it.nome, it.endereco, it.banco.id, it.ativo) }

    fun desativarAgencia(id: Long) {
        val agencia = Agencia.findById(id) ?: throw NotFoundException("Agência não encontrada. ")
        agencia.ativo = false
    }

}
