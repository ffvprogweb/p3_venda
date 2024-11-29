package com.fatec.venda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String codigoProduto;
    private String descricao;
    private double preco;
    private char tamanho;


    public Produto(String codigoProduto, String descricao, double preco, char tamanho) {
        setCodigoProduto(codigoProduto);
        setDescricao(descricao);
        setPreco(preco);
        setTamanho(tamanho);
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        if (codigoProduto == null || codigoProduto.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto é obrigatória.");
        }
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto é obrigatória.");
        }
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        tamanho = Character.toUpperCase(tamanho); // Garante que a comparação seja case-insensitive.
        if (tamanho != 'P' && tamanho != 'M' && tamanho != 'G' && tamanho != 'X') {
            throw new IllegalArgumentException("Tamanho inválido. Use P, M, G ou X.");
        }
        this.tamanho = tamanho;
    }
}
