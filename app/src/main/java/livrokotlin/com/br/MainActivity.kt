package livrokotlin.com.br

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ligando p.Adpter para o nosso componente de layout
        val produtosAdpter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        list_view_produtos.adapter = produtosAdpter

        //Interação do botão para add na lista
        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString()

            if (produto.isNotEmpty()) {
                produtosAdpter.add(produto)
                txt_produto.text.clear()
            } else {
                txt_produto.error = "Preencha um valor"
            }
        }

        //Remover item da lista
        list_view_produtos.setOnItemLongClickListener() {adtp : AdapterView<*>, view : View, position: Int, id: Long ->
            //buscando	o	item	clicado
            val item = produtosAdpter.getItem(position)
            //removendo	o	item	clicado	da	lista
            produtosAdpter.remove(item)

            //retorno indicando que	o  click foi realizado com sucesso
            true
        }

    }
}