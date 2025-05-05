package br.com.stellar.service

import br.com.stellar.entities.Conta
import br.com.stellar.form.ContaForm
import br.com.stellar.model.ContaDTO
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional

@ApplicationScoped
class ContaService {

    @Transactional
    fun criarConta(form: ContaForm) = Conta.create(form).persist()

    fun listContas(): List<ContaDTO> = Conta.findAll().list().map {
        ContaDTO(
            it.id,
            agenciaId = it.agencia.id,
            usuarioId = it.usuario.id,
            tipoConta = it.tipoConta,
            saldo = it.saldo,
            cartaoCredito = it.cartaoCredito,
            saldoCartaoCredito = it.saldoCartaoCredito,
            possuiLis = it.possuiLis,
            saldoLis = it.saldoLis
        )
    }

}
