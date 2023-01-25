package com.example.pastries.servlet;

import com.example.pastries.dao.DaoFactory;
import com.example.pastries.dao.entity.Pastry;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;



@WebServlet(urlPatterns = "/pastry-find")
public class PastryFindServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("s");

        List<Pastry> pastryList = DaoFactory.createPastryDao().findByName(search);


        req.setAttribute("pastryList", pastryList );


        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-find.jsp");

        rd.forward(req,resp);
    }
}
