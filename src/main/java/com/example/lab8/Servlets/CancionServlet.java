package com.example.lab8.Servlets;

import com.example.lab8.Beans.Cancion;
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
        switch (action){
            case "inicio" -> {
                request.setAttribute("listaCanciones",cancionDao.obtenerTodasCanciones());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
                requestDispatcher.forward(request,response);
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

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
                requestDispatcher.forward(request, response);
            }

            case "favorito" -> {
                String id = request.getParameter("id");
                cancionDao.favorito(id);
                response.sendRedirect(request.getContextPath() + "/listaFavoritos");
            }

        }
    }
    public Cancion leerParametrosRequest(HttpServletRequest request) {
        String jobId = request.getParameter("jobId");
        String jobTitle = request.getParameter("jobTitle");
        String minSalaryStr = request.getParameter("minSalary");
        String maxSalaryStr = request.getParameter("maxSalary");

        String idcancion = request.getParameter("cancionId");
        String cancion_nombre = request.getParameter("cancionNombre");;
        String banda = request.getParameter("banda");
        String favorito = request.getParameter("favorito");

        Cancion cancion = new Cancion();
        cancion.setIdcancion(Integer.parseInt(idcancion));
        cancion.setCancion(cancion_nombre);
        cancion.setBanda(banda);
        cancion.setFavorito(Integer.parseInt(favorito));
        return cancion;
    }
}
