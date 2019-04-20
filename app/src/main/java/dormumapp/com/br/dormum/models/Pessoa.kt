package dormumapp.com.br.dormum.models

import java.time.LocalDate
import java.util.*

open class Pessoa (nome: String, sexo: String, cidade: String) {

    private var nome: String
    private var sexo: String
    private var cidade: String

    init {
        this.nome = nome
        this.sexo = sexo
        this.cidade = cidade
    }
}