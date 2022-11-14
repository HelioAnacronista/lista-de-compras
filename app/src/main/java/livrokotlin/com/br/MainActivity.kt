package livrokotlin.com.br

import android.os.Bundle
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


    }
}