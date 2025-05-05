package br.com.stellar.entities

import jakarta.persistence.*
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transacao")
class Transacao(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "conta_origem_id", nullable = false)
    var contaOrigem: Conta = Conta(),

    @ManyToOne
    @JoinColumn(name = "conta_destino_id", nullable = false)
    var contaDestino: Conta = Conta(),

    @Column(nullable = false)
    var valor: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var dataHora: LocalDateTime = LocalDateTime.now()

) : PanacheEntityBase {

    companion object : PanacheCompanion<Transacao>
}
