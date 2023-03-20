package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.StockDTO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.StockService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "stockSuccessController", value = "/stock/textsuccess")
@Log4j2
public class StockSuccessController extends HttpServlet {
    private StockService stockService = StockService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("success....");

        ServletContext servletContext = req.getServletContext();

        try {
            List<StockDTO> stockDTO = stockService.listAll();
            req.setAttribute("stockDTO", stockDTO);
            req.getRequestDispatcher("/WEB-INF/stock/textsuccess.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
