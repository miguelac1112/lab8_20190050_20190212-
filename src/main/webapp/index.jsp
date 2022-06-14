
<%@ page import="com.example.lab8.Beans.Banda" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listabandas" scope="request" type="java.util.ArrayList<com.example.lab8.Beans.Banda>" />
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Bienvenido"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="pregunta1" value="pregunta1"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>lista de recomendaciones:</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>Ver</th>
                    </tr>
                    </thead>

                    <tbody>
                    <% 
                        for (Banda banda : listabandas) { %>
                    <tr>
                        <td><%=banda.getId() %>
                        </td>
                        <td><%=banda.getNombre_cancion() %>
                        </td>
                        <td><%=banda.getNombre_banda() %>
                        </td>
                        <td>
                            <button type="button" class="btn btn-success">Mas de la banda</button>
                        </td>

                    </tr>
                    <% 
                    } %>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
