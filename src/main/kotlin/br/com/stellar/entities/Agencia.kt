package br.com.stellar.entities

import br.com.stellar.form.AgenciaForm
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*

@Entity
@Table(name = "agencia")
class Agencia(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "banco_id", nullable = false)
    var banco: Banco = Banco(),

    @Column(nullable = false, length = 100)
    var nome: String = "",

    @Column(length = 255)
    var endereco: String = "",

    var ativo: Boolean = true

) : PanacheEntityBase {

    companion object : PanacheCompanion<Agencia> {
        fun create(form: AgenciaForm): Agencia {
            val banco = Banco.findById(form.bancoId)
                ?: throw IllegalArgumentException("Banco com ID ${form.bancoId} não encontrado.")

            return Agencia().apply {
                this.nome = form.nome
                this.endereco = form.endereco
                this.banco = banco
            }
        }
    }
}
