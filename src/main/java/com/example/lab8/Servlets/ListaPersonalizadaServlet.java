package com.example.lab8.Servlets;

import com.example.lab8.Beans.Cancion;
import com.example.lab8.Beans.ListaPersonalizada;
import com.example.lab8.Daos.CancionDao;
import com.example.lab8.Daos.ListaPersonalizadaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListaPersonalizadaServlet", value = "/ListasPersonalizada")
public class ListaPersonalizadaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null? "inicio" : request.getParameter("a");
        ListaPersonalizadaDao listaPersonalizadaDao = new ListaPersonalizadaDao();
        switch (action){
            case "inicio" -> {
                request.setAttribute("listaPersonalizada",listaPersonalizadaDao.obtenerListas());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaPersonalizada.jsp");
                requestDispatcher.forward(request,response);
            }
            case "verCanciones" -> {
                String id = request.getParameter("id");
                request.setAttribute("listaCanciones", listaPersonalizadaDao.verCanciones(id));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaPersonalizada_canciones.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        ListaPersonalizadaDao listaPersonalizadaDao = new ListaPersonalizadaDao();

        switch (action) {
            case "guardar" -> {
                String nombre_lista = request.getParameter("nombre_lista");

                try {
                    listaPersonalizadaDao.crearLista(nombre_lista);
                    response.sendRedirect(request.getContextPath() + "/ListasPersonalizada");

                } catch (NumberFormatException e) {
                    System.out.println("error al parsear");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaPersonalizada.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        }
    }

}
