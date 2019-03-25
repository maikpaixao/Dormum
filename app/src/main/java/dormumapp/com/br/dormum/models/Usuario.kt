package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

class Usuario(username: String, password: String, nome: String, dataNascimento: LocalDate, sexo: String, telefone: Int, cidade: String): Pessoa(nome, dataNascimento, sexo, telefone, cidade) {

    var username: String
    var password: String

    init {
        this.username = username
        this.password = password
    }
}