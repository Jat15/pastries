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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = "/pastry-find")
public class PastryFindServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("s");

        Optional<Pastry> pastry = DaoFactory.createPastryDao().findByName(search);

        System.out.println(search);
        /*req.setAttribute("pastryList", );


        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-find.jsp");

        rd.forward(req,resp);*/
    }




}
