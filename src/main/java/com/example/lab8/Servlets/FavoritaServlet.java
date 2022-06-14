package com.example.lab8.Servlets;

import com.example.lab8.Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FavoritaServlet", value = "/listaFavoritos")
public class FavoritaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null? "inicio" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();

        switch (action){
            case "inicio" -> {
                request.setAttribute("listaFavoritos",cancionDao.obtenerFavoritos());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaFavoritos.jsp");
                requestDispatcher.forward(request,response);
            }
            case "borrar" -> {
                String id = request.getParameter("id");
                cancionDao.no_favorito(id);
                response.sendRedirect(request.getContextPath() + "/listaFavoritos");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
