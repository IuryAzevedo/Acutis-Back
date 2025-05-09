package br.com.stellar.service

import br.com.stellar.entities.Banco
import br.com.stellar.form.BancoForm
import br.com.stellar.model.BancoDTO
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException
import java.time.LocalDateTime

@ApplicationScoped
class BancoService {


    @Transactional
    fun criarBanco(form: BancoForm) = Banco.create(form).persist()

    fun listBancos(): List<BancoDTO> = Banco.findAll().list().map { BancoDTO(it.id, it.nome, it.dataFundacao, it.ativo) }

    fun desativarBanco(id: Long) {
        val banco = Banco.findById(id) ?: throw NotFoundException("Banco não encontrado. ")
        banco.ativo = false
    }

}