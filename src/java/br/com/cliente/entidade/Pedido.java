/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cliente.entidade;

import br.com.cliente.util.Utilitarios;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Orlando
 */

public class Pedido {
    private final Integer idPedido;
    private static Integer cont = 0;
    private String cliente;
    private Produto produto;
    private Integer qtde;
    private final Date data;    
    

    public Pedido(String cliente, Produto produto, Integer qtde) {
        idPedido = ++cont;
        data = new Date();
        this.cliente = cliente;
        this.produto = produto;
        this.qtde = qtde;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public String getData() {
        return Utilitarios.simpleDateFormat.format(data);
    }

    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + ", produto=" + produto + ", qtde=" + qtde + '}';
    }   
}
