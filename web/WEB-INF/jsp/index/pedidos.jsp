<%-- 
    Document   : pedidos
    Created on : 03/11/2013, 14:07:52
    Author     : Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="main" class="shell">
    <!-- Begin Content -->
    <div id="content">
        <div class="post">
            <h2>Pedidos!</h2>
            <br/>
            <table class="tabela">
                <thead>
                    <tr>
                        <th>Cód</th>
                        <th>Cliente</th>
                        <th>Produto</th>
                        <th>Qtd.</th>
                        <th>Data</th>
                    </tr>        
                </thead>
                <tbody>
                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td>${pedido.idPedido}</td>
                            <td>${pedido.cliente}</td>
                            <td>${pedido.produto.nome}</td>
                            <td>${pedido.qtde}</td>
                            <td>${pedido.data}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="cl">&nbsp;</div>
</div>