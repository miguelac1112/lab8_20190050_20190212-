<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab8.Beans.ListaPersonalizada" %>
<jsp:useBean id="listaPersonalizada" scope="request" type="java.util.ArrayList<com.example.lab8.Beans.ListaPersonalizada>"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Listas Personalizadas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="tpc"/>
            </jsp:include>
            <div class="row-5 pt-4 px-3 titlecolor">
                <div class="row gx-lg-5">
                    <div class="col-lg-6">
                        <h1 class='text-light'>Listas Personalizadas Creadas</h1>
                    </div>
                </div>
            </div>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Crear lista"
                       aria-label="Crear lista" aria-describedby="button-addon2"
                       name="textoBuscar" value="" />
                <button class="btn btn-outline-info" type="submit" id="button-addon2">Crear</button>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>#</th>
                        <th>Nombre Lista</th>
                    </thead>
                    <%
                        for (ListaPersonalizada lista : listaPersonalizada) {
                    %>
                        <tr>
                            <td><%=lista.getIdLista()%></td>
                            <td><%=lista.getNombre_lista()%></td>
                        </tr>
                    <%
                        } %>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
