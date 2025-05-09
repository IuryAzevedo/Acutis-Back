package br.com.stellar.entities

import br.com.stellar.form.BancoForm
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "BANCO")
class Banco(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(
        nullable = false, //
        updatable = false, //
    ) var id: Long, //

    var nome: String,

    @Column(name = "data_fundacao")
    var dataFundacao: LocalDateTime,

    var ativo: Boolean = true

): PanacheEntityBase {

    constructor() : this(
        id = 0,
        nome = "",
        dataFundacao = LocalDateTime.now(),
        ativo = true
    )

    companion object : PanacheCompanion<Banco> {

        fun create(
            form: BancoForm
        ): Banco {
            return Banco().apply {
                this.nome = form.nome
                this.dataFundacao = form.dataFundacao
            }
        }

    }

}