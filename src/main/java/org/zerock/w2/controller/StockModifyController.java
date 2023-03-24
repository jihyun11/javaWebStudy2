package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.StockDTO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.StockService;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "stockModifyController", value = "/stock/modify")
@Log4j2
public class StockModifyController extends HttpServlet {

    private StockService stockService = StockService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            StockDTO stockDTO = stockService.get(title);

            //데이터담기
            req.setAttribute("dto", stockDTO);
            req.getRequestDispatcher("/WEB-INF/stock/textmodify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("modify get... error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleStr = req.getParameter("title");

        StockDTO stockDTO = StockDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .build();

        log.info("/stock/modify POST...");
        log.info(stockDTO);
        try {
            stockService.StockModify(stockDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/stock/list");
    }
}
