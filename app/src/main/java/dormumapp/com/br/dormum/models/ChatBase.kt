package dormumapp.com.br.dormum.models

class ChatBase(usuario: String, message: String, image: Int){

    val usuario: String
    val message: String
    val image: Int

    init {
        this.usuario = usuario
        this.message = message
        this.image = image
    }

    fun getUsuarioChat(): String{
        return this.usuario
    }

    fun getMessageChat(): String{
        return this.message
    }

    fun getImageChat(): Int{
        return this.image
    }
}