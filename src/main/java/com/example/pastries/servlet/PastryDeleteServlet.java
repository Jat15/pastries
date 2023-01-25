package com.example.pastries.servlet;

import com.example.pastries.dao.DaoFactory;
import com.example.pastries.dao.entity.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/pastry-delete")
public class PastryDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Faire le delete par ID serait plus simple
        String param;
        String paramId = req.getParameter("id");

        try {
            Long id = Long.parseLong(paramId);

            Optional<Pastry> pastry = DaoFactory.createPastryDao().get(id);

            Pastry pastry1 = pastry.get();
            DaoFactory.createPastryDao().delete(pastry1);
            param = "delete_pastry";
        } catch (Exception e) {
            param = "error_delete_pastry";
        }


        // Une autre méthode ?
        resp.sendRedirect("/pastry-list?status="+param);

    }
}
