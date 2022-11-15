package livrokotlin.com.br

import android.content.Intent
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

        //Navegação para criaçao de produto
        btn_adicionar.setOnClickListener {
            //Criando a Intant explicita
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
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