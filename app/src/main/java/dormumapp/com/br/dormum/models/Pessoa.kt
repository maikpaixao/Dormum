package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

open class Pessoa (nome: String, dataNascimento: LocalDate, sexo: String, telefone: Int, cidade: String) {

    private var nome: String
    private var dataNascimento: LocalDate
    private var sexo: String
    private var telefone: Int
    private var cidade: String

    init {
        this.nome = nome
        this.dataNascimento = dataNascimento
        this.sexo = sexo
        this.telefone = telefone
        this.cidade = cidade
    }
}