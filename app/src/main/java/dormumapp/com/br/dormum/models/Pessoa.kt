package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

open class Pessoa (nome: String, cpf: Int, dataNascimento: LocalDate, sexo: String, endereco: String, telefone: Int, cidade: String) {

    private var nome: String
    private var cpf: Int
    private var dataNascimento: LocalDate
    private var sexo: String
    private var endereco: String
    private var telefone: Int
    private var cidade: String

    init {
        this.nome = nome
        this.cpf = cpf
        this.dataNascimento = dataNascimento
        this.sexo = sexo
        this.endereco = endereco
        this.telefone = telefone
        this.cidade = cidade
    }
}