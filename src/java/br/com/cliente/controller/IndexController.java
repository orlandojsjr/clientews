/**
 * *
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.cliente.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.cliente.entidade.Pedido;
import br.com.cliente.util.Utilitarios;

@Resource
public class IndexController {

    private final Result result;

    public IndexController(Result result) {
        this.result = result;
    }

    @Path("/")
    public void index() {
        result.include("produtos", Utilitarios.getProdutoList());
    }

    @Get("/produtosList")
    public void produtoList() {
        Utilitarios.addLog("Consulta de Catalogo.");
        result.include("produtos", Utilitarios.receberCatalogProdutos(consultarCatalogoProdutos("Orlando")));
        result.redirectTo(this).index();
    }
    
    @Get("/limparProdutosList")
    public void limparProdutoList() {
        Utilitarios.addLog("Limpar catalogo.");        
        result.include("produtos", Utilitarios.getProdutoListEmpty());
        result.redirectTo(this).index();
    }

    @Get("/pedidos")
    public void pedidos() {
        result.include("pedidos", Utilitarios.getPedidoList());
    }

    @Post("/novoPedido")
    public void novoPedido(Integer id, Integer qtde) {
        Pedido pedido = new Pedido("Orlando", Utilitarios.getProdutoList().get(id-1), qtde);
        String log = Utilitarios.addPedido(pedido);
        Utilitarios.addLog(log + " " + pedido.toString());
        result.redirectTo(this).pedidos();
    }

    @Get("/logs")
    public void logs() {
        result.include("logs", Utilitarios.getLogList());
    }

    private static String consultarCatalogoProdutos(java.lang.String idCliente) {
        br.com.cliente.webservice.Pedido service = new br.com.cliente.webservice.Pedido();
        br.com.cliente.webservice.PedidoWS port = service.getPedidoWSPort();
        return port.consultarCatalogoProdutos(idCliente);
    }

    private static String realizarPedido(java.lang.String idCliente, java.lang.String idProduto, java.lang.String qtde) {
        br.com.cliente.webservice.Pedido service = new br.com.cliente.webservice.Pedido();
        br.com.cliente.webservice.PedidoWS port = service.getPedidoWSPort();
        return port.realizarPedido(idCliente, idProduto, qtde);
    }
}
