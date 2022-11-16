package livrokotlin.com.br

import android.graphics.drawable.Drawable

data class Produto(val nome: String, val quantidade: Int, val valor : Double, val foto: Drawable? = null)