package com.example.lab8.Servlets;

import com.example.lab8.Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancionServlet", value = "/listaCanciones")
public class CancionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null? "inicio" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();
        switch (action) {
            case "inicio" -> {
                request.setAttribute("inicio","vacio");

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
                requestDispatcher.forward(request,response);
            }
            case "listar" -> {
                request.setAttribute("listaCanciones", cancionDao.obtenerTodasCanciones());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
                requestDispatcher.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();

        switch (action){
            case "buscar" -> {
                String textoBuscar = request.getParameter("textoBuscar");
                request.setAttribute("textoBuscar",textoBuscar);
                request.setAttribute("listaCanciones", cancionDao.CancionesPorBanda(textoBuscar));

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobs/lista.jsp");
                requestDispatcher.forward(request, response);
            }

        }
    }
}
