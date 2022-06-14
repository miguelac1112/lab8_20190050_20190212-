<%@ page import="com.example.lab8.Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="textoBuscar" scope="request" type="java.lang.String" class="java.lang.String" />
<jsp:useBean id="listaCanciones" scope="request" type="java.util.ArrayList<com.example.lab8.Beans.Cancion>"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones por Banda"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="tpc"/>
            </jsp:include>
            <div class="row-5 pt-4 px-3 titlecolor">
                <div class="row gx-lg-5">
                    <div class="col-lg-6">
                        <h1 class='text-light'>Lista de Canciones</h1>
                    </div>
                    <div class="col-lg-3">
                    </div>
                    <div class="col-lg-3">
                        <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones?a=listar"> Mostrar todas las canciones</a>
                    </div>
                </div>
            </div>
            <form method="post" action="<%=request.getContextPath()%>/listaCanciones?a=buscar">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Buscar por ID o título del trabajo"
                           aria-label="Buscar por ID o título del trabajo" aria-describedby="button-addon2"
                           name="textoBuscar" value="<%=textoBuscar%>" />
                    <button class="btn btn-outline-info" type="button" id="button-addon2">Buscar</button>
                </div>
            </form>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>#</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                    </thead>
                    <%
                        for (Cancion cancion : listaCanciones) {
                    %>
                    <tr>
                        <td><%=cancion.getIdcancion()%></td>
                        <td><%=cancion.getCancion()%></td>
                        <td><%=cancion.getBanda()%></td>
                        <td><input name="favoritos" id="favoritos" multiple  type="checkbox"  value="" aria-label="..." style="width:30px; height:30px "></td>
                    </tr>
                    <% ;
                    } %>
                </table>
            </div>
        </div>
    </body>
</html>