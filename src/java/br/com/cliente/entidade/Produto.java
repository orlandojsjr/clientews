/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.entidade;

import br.com.cliente.util.Utilitarios;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Orlando
 */
@XStreamAlias("Produto")
public class Produto {

    private Integer id;
    private String nome;
    private String imagem;
    private String imagem2;
    private String preco;

    public Produto() {
    }


    public Produto(Integer id, String nome, String imagem, String imagem2, String preco) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.imagem2 = imagem2;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }
    
    public Integer getIdFornecedor() {
        return id - 1;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return Utilitarios.URL_FORCENEDOR + "/" + imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem2() {
        return Utilitarios.URL_FORCENEDOR + "/" + imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + '}';
    }
}
