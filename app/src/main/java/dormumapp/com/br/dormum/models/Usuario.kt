package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

class Usuario(username: String, password: String, nome: String, cpf: Int, dataNascimento: LocalDate, sexo: String, endereco: String, telefone: Int, cidade: String): Pessoa(nome, cpf, dataNascimento, sexo, endereco, telefone, cidade) {

    var username: String
    var password: String

    init {
        this.username = username
        this.password = password
    }
}