package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

class Usuario(username: String, password: String, nome: String, sexo: String, cidade: String): Pessoa(nome, sexo, cidade) {

    var username: String
    var password: String

    init {
        this.username = username
        this.password = password
    }
}