<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="main" class="shell">
    <!-- Begin Content -->
    <div id="content">
        <div class="post">
            <h2>Bem Vindo!</h2>                                        
            <p>Aplicação Cliente do <a href="http://default-environment-eipvd6a5qq.elasticbeanstalk.com/" target="_blank">Fornecedor WS.</a></p>
            <p>Funcionalidades:</p>
            <ul class="">
                <li>Consultar Catálogo de produtos</li>
                <li>Realizar pedidos.</li>
            </ul><br/>

            <form action="<c:url value="/produtosList"/>">
                <input type="submit" value="Consulta Catalogo produtos"/> 
            </form> 
            <form action="<c:url value="/limparProdutosList"/>">
                <input type="submit" value="Limpar Catalogo produtos"/> 
            </form> 
            <div class="cl">&nbsp;</div>
        </div>
    </div>
    <!-- End Content -->
    <div class="cl">&nbsp;</div>
    <!-- Begin Products -->
    <div id="products">
        <h2>Produtos Disponíveis</h2>
        <c:forEach items="${produtos}" var="produto">        
            <div class="product">
                <a href="#" title="Product Link"><img src="<c:url value="${produto.imagem2}"/>" width="163" height="123" alt="Product Image" /></a>
                <div class="price">
                    <div class="inner">
                        <span class="title"></span>
                        <strong><span></span>${produto.preco}<sup></sup></strong>
                    </div>
                </div>
                <div class="info">
                    <p>${produto.nome}</p>
                    <p>
                    <form action="<c:url value="/novoPedido"/>"  method="POST">
                        <label>Qtde:</label><br/>
                        <input type="text" name="qtde" value="1" size="10"/> 
                        <input type="hidden" name="id" value="${produto.id}" size="10"/> 
                        <input type="submit" value="Realizar Pedido"/> 
                    </form> 
                    </p>
                </div>
            </div>
        </c:forEach>            
        <!-- End Products -->
        <div class="cl">&nbsp;</div>
    </div>   
