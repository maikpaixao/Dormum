package dormumapp.com.br.dormum.dao

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.utils.CustomAdapterAlternative
import kotlinx.android.synthetic.main.content_home.*

class RepoImovel{

    private var imoveis = ParseObject("Imoveis")
    var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Imoveis")
    var listaImoveis = ArrayList<Imovel>()

    fun adicionarImovel(imovel: Imovel){
        imoveis.put("imgImovel", imovel.getImagemImovel())
        imoveis.put("tituloImovel", imovel.getTitleImovel())
        imoveis.put("descricaoImovel", imovel.getDescricaoImovel())
        imoveis.put("cidadeImovel", imovel.getCidadeImovel())
        imoveis.put("precoImovel", imovel.getPriceImovel())
        imoveis.put("enderecoImovel", imovel.getEnderecoImovel())
        imoveis.put("quantidadePessoas", imovel.getQtdPessoas())
        imoveis.saveInBackground()
    }

    fun listarImoveis(): ArrayList<Imovel>{
        query.findInBackground(){obj,e->
            var itera = obj.iterator()
            itera.forEach {
                var arq = it.getParseFile("imgImovel") as ParseFile
                var imovel_1   = Imovel(it.getString("tituloImovel").toString(), it.getString("descricaoImovel").toString(),
                        it.getString("enderecoImovel").toString(), it.getString("cidadeImovel").toString(),
                        it.getString("qtdPessoas").toString(), arq, R.drawable.review, "R$ - 250")
                listaImoveis.add(imovel_1)
            }
        }
        return this.listaImoveis
    }
}