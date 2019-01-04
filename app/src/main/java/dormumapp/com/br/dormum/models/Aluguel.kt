package dormumapp.com.br.dormum.models

class Aluguel(imovel: Imovel, usuario: Usuario){

    var imovel: Imovel
    var usuario: Usuario

    init {
        this.imovel = imovel
        this.usuario = usuario
    }

}