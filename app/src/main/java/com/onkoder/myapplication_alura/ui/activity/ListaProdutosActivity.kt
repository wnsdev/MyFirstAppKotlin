package com.onkoder.myapplication_alura.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.onkoder.myapplication_alura.R
import com.onkoder.myapplication_alura.dao.ProdutosDao
import com.onkoder.myapplication_alura.ui.adapter.ListarProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {
    private val dao = ProdutosDao()
    private val adapter = ListarProdutosAdapter(context = this, produtos = dao.listar())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraFab()
        configuraRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualizar(dao.listar())
    }

    private fun configuraFab() {
        val oActivityFormProduto = findViewById<FloatingActionButton>(R.id.oActivityFormProduto)
        oActivityFormProduto.setOnClickListener {
            val intent = Intent(this, FormProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.produtos)
        recyclerView.adapter = adapter
    }
}