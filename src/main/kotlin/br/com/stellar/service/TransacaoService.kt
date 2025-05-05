// package br.com.stellar.service

// import br.com.stellar.entities.Transacao
// import br.com.stellar.form.TransacaoForm
// import br.com.stellar.model.TransacaoDTO
// import jakarta.enterprise.context.ApplicationScoped
// import jakarta.transaction.Transactional
// import java.math.BigDecimal
// import java.time.LocalDateTime

// @ApplicationScoped
// class TransacaoService {

//     @Transactional
//     fun realizarTransacao(form: TransacaoForm) {
//         val contaOrigem = form.contaOrigem
//         val contaDestino = form.contaDestino
//         val valor = form.valor

//         require(contaOrigem.saldo >= valor) { "Saldo insuficiente na conta de origem." }

//         contaOrigem.saldo -= valor
//         contaDestino.saldo += valor

//         val transacao = Transacao(
//             contaOrigem = contaOrigem,
//             contaDestino = contaDestino,
//             valor = valor,
//             dataHora = LocalDateTime.now()
//         )
//         transacao.persist()
//     }

//     fun listarTransacoes(): List<TransacaoDTO> =
//         Transacao.findAll().list().map {
//             TransacaoDTO(
//                 id = it.id,
//                 contaOrigemId = it.contaOrigem.id,
//                 contaDestinoId = it.contaDestino.id,
//                 valor = it.valor,
//                 dataHora = it.dataHora
//             )
//         }
// }
