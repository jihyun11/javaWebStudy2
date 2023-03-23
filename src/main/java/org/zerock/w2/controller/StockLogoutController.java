package org.zerock.w2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.ImagingOpException;
import java.io.IOException;

@WebServlet("/stocklogout")
@Log4j2
public class StockLogoutController extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("stock logout....");
        HttpSession session = req.getSession();

        session.removeAttribute("logoutInfo");
        session.invalidate();

        resp.sendRedirect("/stocklogin");
    }
}
