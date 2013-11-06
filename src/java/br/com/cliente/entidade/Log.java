/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cliente.entidade;

import br.com.cliente.util.Utilitarios;
import java.util.Date;

/**
 *
 * @author Orlando
 */
public class Log {
    private final Integer id;
    private static Integer cod =0;
    private String descricao;
    private final Date data;

    public Log(String descricao) {
        id = ++cod;        
        data = new Date();
        this.descricao = descricao;
    }

    public  Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return Utilitarios.simpleDateFormat.format(data);
    }
}