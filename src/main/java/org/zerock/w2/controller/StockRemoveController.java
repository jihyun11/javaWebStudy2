package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.service.StockService;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "stockRemoveController", value = "/stock/remove")
@Log4j2
public class StockRemoveController extends HttpServlet {

    private StockService stockService = StockService.INSTANCE;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        log.info("title: " + title);

        try {
            stockService.StockRemove(title);


        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
        resp.sendRedirect("/stock/textsuccess");
    }
}
