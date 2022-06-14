package com.example.lab8.Servlets;

import com.example.lab8.Daos.BandaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BandaDaoServlet", value = "/listaRecomendados")
public class BandaDaoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BandaDao bandaDao = new BandaDao();
        request.setAttribute("listabandas",bandaDao.obtenerListarecomendado());
        RequestDispatcher view =request.getRequestDispatcher("listaRecomendados.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
