package livrokotlin.com.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.view.*
import livrokotlin.com.br.domain.entities.Produto
import livrokotlin.com.br.domain.utils.produtosGlobal

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //definição	do	ouvinte	do	botão
        btn_inserir.setOnClickListener {
            //pegando	os	valores	digitados	pelo	usuário
            val produto = txt_produto.text.toString()
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()

            //verificando	se	o	usuário	digitou	algum	valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {
                val prod = Produto(produto, qtd.toInt(), valor.toDouble())
                //add a variavel global
                produtosGlobal.add(prod)
                //limpar caxinhas
                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()
            } else {

                txt_produto.error = if (txt_produto.text.isNotEmpty()) "Preencha o nome do produto" else null

                txt_qtd.error = if (txt_qtd.text.isNotEmpty()) "Preencha a quantidade do produto" else null

                txt_valor.error = if (txt_valor.text.isNotEmpty()) "Preencha o valor do produto" else null
            }

            if (produto.isNotEmpty()) {

                txt_produto.text.clear()
            } else {
                txt_produto.error = "Preencha um valor"
            }



        }




    }
}