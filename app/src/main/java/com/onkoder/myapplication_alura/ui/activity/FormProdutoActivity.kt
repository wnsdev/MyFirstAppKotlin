package com.onkoder.myapplication_alura.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.onkoder.myapplication_alura.R
import com.onkoder.myapplication_alura.dao.ProdutosDao
import com.onkoder.myapplication_alura.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {
    private val dao = ProdutosDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val ctaSalvar = findViewById<Button>(R.id.cta_salvar)
        ctaSalvar.setOnClickListener {
            val novoProduto = produto()
            dao.adicionar(novoProduto)
            finish()
        }
    }

    private fun produto(): Produto {
        val campoNome = findViewById<EditText>(R.id.nome)
        val campoDescricao = findViewById<EditText>(R.id.descricao)
        val campoValor = findViewById<EditText>(R.id.valor)
        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorString = campoValor.text.toString()
        val valor = if (valorString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorString)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}