package dormumapp.com.br.dormum.controllers

import android.util.Log
import dormumapp.com.br.dormum.dao.RepoImovel
import dormumapp.com.br.dormum.exceptions.NotFoundElement
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.models.Usuario
import java.lang.Exception

class ControllerImovel{
    private var repoImovel: RepoImovel

    init {
        repoImovel = RepoImovel()
    }

    fun adicionarImovel(imovel: Imovel){
        try {
            if(imovel == null){
                throw NotFoundElement("Elemento não encontrado!")
            }else{
                repoImovel.adicionarImovel(imovel)
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }
    }

    fun listarImoveis(): ArrayList<Imovel>{
        return repoImovel.listarImoveis()
    }

    fun alugarImovel(usuario: Usuario, imovel: Imovel){
        try {
            if(imovel != null && usuario !=null){
                repoImovel.alugarImovel(usuario, imovel)
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }
    }
}