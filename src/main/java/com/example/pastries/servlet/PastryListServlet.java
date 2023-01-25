package com.example.pastries.servlet;

import com.example.pastries.dao.DaoFactory;
import com.example.pastries.dao.PastryDao;
import com.example.pastries.dao.entity.Pastry;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pastry-list")
public class PastryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Pastry> pastryList = DaoFactory.createPastryDao().getAll();
        req.setAttribute("pastryList", pastryList);


        String status = req.getParameter("status");
        req.setAttribute("status", status);


        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-list.jsp");

        rd.forward(req,resp);

    }
}
