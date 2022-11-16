package livrokotlin.com.br

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnInserir = findViewById<Button>(R.id.btn_inserir)

        val spnSelect = findViewById<Spinner>(R.id.spinner)
        spnSelect.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("Alimento", "Limpeza", "Utilidade", "Fruta", "Bebida", "Frios"))


        btnInserir.setOnClickListener {
            val produto = findViewById<EditText>(R.id.txt_produto)
            val qtd = findViewById<EditText>(R.id.txt_qtd)
            val valor = findViewById<EditText>(R.id.txt_valor)

            val tiposSpinner = findViewById<Spinner>(R.id.spinner)
            val tipoAlimento = tiposSpinner.selectedItem as String

            if (produto.text.isNotEmpty() && qtd.text.toString().isNotEmpty() && valor.text.toString().isNotEmpty()) {
                var CODE_IMG = 0
                if (tipoAlimento == "Alimento") CODE_IMG = 1
                if (tipoAlimento == "Limpeza") CODE_IMG = 2
                if (tipoAlimento == "Utilidade") CODE_IMG = 3
                if (tipoAlimento == "Fruta") CODE_IMG = 4
                if (tipoAlimento == "Bebida") CODE_IMG = 5
                if (tipoAlimento == "Frios") CODE_IMG = 6



                var drawable: Drawable?
                if (CODE_IMG == 1) {
                    drawable = ResourcesCompat.getDrawable(resources, R.drawable.alimentos, null)
                } else if (CODE_IMG == 2) {
                    drawable = ResourcesCompat.getDrawable(resources, R.drawable.utils, null)
                } else if (CODE_IMG == 4) {
                    drawable = ResourcesCompat.getDrawable(resources, R.drawable.frutas, null)
                } else if (CODE_IMG == 5) {
                    drawable = ResourcesCompat.getDrawable(resources, R.drawable.bebidas, null)
                } else {
                    drawable = ResourcesCompat.getDrawable(resources, R.drawable.frios, null)
                }




                val prod = Produto(
                    produto.text.toString(),
                    qtd.text.toString().toInt(),
                    valor.text.toString().toDouble(),
                    foto = drawable
                )
                produtosGlobal.add(prod)

                produto.text.clear()
                qtd.text.clear()
                valor.text.clear()

            } else {
                produto.error = if (produto.text.isEmpty()) "Preencha o nome do produto" else null
                qtd.error = if (qtd.text.isEmpty()) "Preencha a quantidade" else null
                valor.error = if (valor.text.isEmpty()) "Preencha o valor" else null
            }

        }
    }
}
