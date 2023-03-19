package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.StockDTO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.StockService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "stockTextController", value = "/stock/text")
@Log4j2
public class StockTextController extends HttpServlet {

    private StockService stockService = StockService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("게시글 등록....");
        req.getRequestDispatcher("/WEB-INF/stock/text.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockDTO stockDTO = StockDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .build();
        log.info("/stock/text POST.......");
        log.info(stockDTO);
        try {
            stockService.register(stockDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/stock/textsuccess");
    }
}
