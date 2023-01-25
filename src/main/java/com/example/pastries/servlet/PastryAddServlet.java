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

@WebServlet(urlPatterns = "/pastry-add")
public class PastryAddServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-add.jsp");

        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String img = req.getParameter("img");

        String param;

        try {

            Pastry pastry = new Pastry();

            pastry.setName(name);
            pastry.setDescription(description);
            pastry.setImg(img);


            DaoFactory.createPastryDao().create(pastry);

            param = "add_pastry";

        } catch(Exception e) {
            param = "error_add_pastry";

        }

        // Une autre méthode ?
        resp.sendRedirect("/pastry-list?status="+param );

    }
}
