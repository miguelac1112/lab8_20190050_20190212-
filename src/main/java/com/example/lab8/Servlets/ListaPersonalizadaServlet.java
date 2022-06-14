package com.example.lab8.Servlets;

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
