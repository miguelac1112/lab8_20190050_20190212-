<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab8.Beans.Cancion" %>
<jsp:useBean id="listaFavoritos" scope="request" type="java.util.ArrayList<com.example.lab8.Beans.Cancion>"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones Favoritas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="row gx-lg-5">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones</h1>
                </div>
            </div>
            <br>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>#</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>ELIMINAR</th>
                    </thead>
                    <%
                        for (Cancion cancion : listaFavoritos) {
                    %>
                    <tr>
                        <td><%=cancion.getIdcancion()%></td>
                        <td><%=cancion.getCancion()%></td>
                        <td><%=cancion.getBanda()%></td>
                        <td><a href="<%=request.getContextPath()%>/listaFavoritos?a=borrar&id=<%=cancion.getIdcancion()%>"
                               class="btn btn-danger">(< / 3)</a></td>
                    </tr>
                    <%
                        } %>
                </table>
            </div>
            <a href="listaCanciones"><button type="button" class="btn btn-secondary ">Regresar</button></a>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
