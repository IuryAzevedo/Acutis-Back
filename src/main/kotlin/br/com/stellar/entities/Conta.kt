package br.com.stellar.entities

import br.com.stellar.form.ContaForm
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "conta")
class Conta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "agencia_id", nullable = false)
    var agencia: Agencia = Agencia(),

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: Usuario = Usuario(),

    @Column(name = "tipo_conta", nullable = false)
    var tipoConta: String = "",

    @Column(nullable = false)
    var saldo: BigDecimal = BigDecimal.ZERO,

    @Column(name = "cartao_credito")
    var cartaoCredito: Boolean? = null,

    @Column(name = "saldo_cartao_credito")
    var saldoCartaoCredito: BigDecimal? = null,

    @Column(name = "possui_lis")
    var possuiLis: Boolean? = null,

    @Column(name = "saldo_lis")
    var saldoLis: BigDecimal? = null

) : PanacheEntityBase {

    companion object : PanacheCompanion<Conta> {
        fun create(form: ContaForm): Conta {
            val agencia = Agencia.findById(form.agenciaId)
                ?: throw IllegalArgumentException("Agência com ID ${form.agenciaId} não encontrada.")
            val usuario = Usuario.findById(form.usuarioId)
                ?: throw IllegalArgumentException("Usuário com ID ${form.usuarioId} não encontrado.")

            return Conta().apply {
                this.agencia = agencia
                this.usuario = usuario
                this.tipoConta = form.tipoConta
                this.saldo = form.saldo
                this.cartaoCredito = form.cartaoCredito
                this.saldoCartaoCredito = form.saldoCartaoCredito
                this.possuiLis = form.possuiLis
                this.saldoLis = form.saldoLis
            }
        }
    }
}
