<%-- 
    Document   : logs
    Created on : 03/11/2013, 14:07:57
    Author     : Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="main" class="shell">
    <!-- Begin Content -->
    <div id="content">
        <div class="post">
            <h2>Log Transações</h2>
            <br/>
            <table class="tabela">
                <thead>
                    <tr>
                        <th>Cód</th>
                        <th>Descrição</th>                    
                        <th>Data</th>
                    </tr>        
                </thead>
                <tbody>
                    <c:forEach items="${logs}" var="log">
                        <tr>
                            <td>${log.id}</td>
                            <td>${log.descricao}</td>
                            <td>${log.data}</td>                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="cl">&nbsp;</div>
</div>