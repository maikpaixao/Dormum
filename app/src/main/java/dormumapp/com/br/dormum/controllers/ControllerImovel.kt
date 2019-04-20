package dormumapp.com.br.dormum.controllers

import android.util.Log
import dormumapp.com.br.dormum.dao.RepoImovel
import dormumapp.com.br.dormum.models.Imovel
import java.lang.Exception

class ControllerImovel{
    private var repoImovel: RepoImovel

    init {
        repoImovel = RepoImovel()
    }

    fun adicionarImovel(imovel: Imovel){
        try {
            if(imovel != null){
                repoImovel.adicionarImovel(imovel)
            }
        }catch (ex: Exception){
            Log.d("TAG", "Não foi possível adicionar o imóvel.")
        }
    }

    fun listarImoveis(): ArrayList<Imovel>{
        return repoImovel.listarImoveis()
    }
}