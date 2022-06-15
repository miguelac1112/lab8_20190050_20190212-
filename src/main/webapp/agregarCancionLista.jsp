<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab8.Beans.ListaPersonalizada" %>
<jsp:useBean id="idCancion" scope="request" type="com.example.lab8.Beans.Cancion" />
<jsp:useBean type="java.util.ArrayList<com.example.lab8.Beans.ListaPersonalizada>" scope="request" id="listas"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Listas Personalizadas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="row-5 pt-4 px-3 titlecolor">
                <div class="row gx-lg-5">
                    <div class="col-lg-6">
                        <h1 class='text-light'>Elige la lista</h1>
                    </div>
                    <div class="col-lg-3">
                    </div>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>#</th>
                        <th>Nombre Lista</th>
                        <th>Canciones en la lista</th>
                    </thead>
                    <%
                        for (ListaPersonalizada lista : listas) {
                    %>
                    <tr>
                        <td><%=lista.getIdLista()%></td>
                        <td><%=lista.getNombre_lista()%></td>
                        <td><input name="idLista" id="idLista" class="btn btn-primary"  type="checkbox"  value="<%=lista.getIdLista()%>" aria-label="..." style="width:30px; height:30px "></td>
                        <td><input type="hidden" name="idCancion" id="idCancion" value="<%=idCancion.getIdcancion()%>" /></td>
                    </tr>
                    <%
                        } %>
                </table>
                <a href="listaCanciones"><button type="button" class="btn btn-secondary ">Regresar</button></a>
                <button type="submit" class="btn btn-primary " data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Agregar
                </button>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
