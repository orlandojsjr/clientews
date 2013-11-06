/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.util;


import br.com.cliente.entidade.Log;
import br.com.cliente.entidade.Pedido;
import br.com.cliente.entidade.Produto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Orlando
 */
public class Utilitarios {

    private static List<Produto> produtoList;
    private static final List<Pedido> pedidoList;
    private static final List<Log> logList;
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final XStream xStream = new XStream(new DomDriver("ISO-8859-1"));
    public static final String URL_FORCENEDOR = "http://default-environment-eipvd6a5qq.elasticbeanstalk.com";
        

    static {
        produtoList = new ArrayList<Produto>();
        pedidoList = new ArrayList<Pedido>();
        logList = new ArrayList<Log>();
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(Produto.class);
    }

    public static List<Produto> getProdutoList() {          
        return produtoList;
    }
    
     public static List<Produto> getProdutoListEmpty() {          
         produtoList.clear();
        return produtoList;
    }

    public static List<Pedido> getPedidoList() {        
        return pedidoList;
    }
   
    public static String addPedido(Pedido pedido){
        pedidoList.add(pedido);
        br.com.cliente.webservice.Pedido service = new br.com.cliente.webservice.Pedido();
        br.com.cliente.webservice.PedidoWS port = service.getPedidoWSPort();        
        return port.realizarPedido(pedido.getCliente(), pedido.getProduto().getIdFornecedor().toString(), pedido.getQtde().toString());        
    }
    
    public static void addLog(String descricao) {
        logList.add(new Log(descricao));
    }

    public static List<Log> getLogList() {        
        return logList;
    }
    
    public static List<Produto> receberCatalogProdutos(String xml){
        return produtoList = (List<Produto>) xStream.fromXML(xml);                
    }
}
