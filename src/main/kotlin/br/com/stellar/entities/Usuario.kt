// Imports mantidos
package br.com.stellar.entities

import br.com.stellar.form.UsuarioForm
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
// import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*

@Entity
@Table(name = "usuario")
class Usuario(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    var id: Long = 0,

    @Column(nullable = false, length = 100)
    var nome: String = "",

    @Column(nullable = false, unique = true, length = 100)
    var email: String = "",

    @Column(nullable = false, unique = true, length = 50)
    var usuario: String = "",

    @Column(nullable = false, length = 100)
    var senha: String = "",

    @Column(nullable = false, length = 255)
    var endereco: String = ""

) : PanacheEntityBase {

    companion object : PanacheCompanion<Usuario> {
        fun create(form: UsuarioForm): Usuario {
            return Usuario(
                nome = form.nome,
                email = form.email,
                usuario = form.usuario,
                senha = form.senha,
                endereco = form.endereco
            )
        }
    }
}
