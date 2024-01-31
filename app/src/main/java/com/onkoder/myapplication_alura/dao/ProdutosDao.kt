package com.onkoder.myapplication_alura.dao

import com.onkoder.myapplication_alura.model.Produto

class ProdutosDao {
    fun adicionar(produto: Produto){
        dados.add(produto)
    }

    fun listar() : List<Produto> {
        return dados.toList()
    }

    companion object {
        private val dados = mutableListOf<Produto>()
    }
}