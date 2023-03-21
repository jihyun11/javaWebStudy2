package org.zerock.w2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dao.StockMemberDAO;
import org.zerock.w2.dto.StockMemberDTO;
import org.zerock.w2.service.StockMemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stocklogin")
@Log
public class StockLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("stock login get....");
        req.getRequestDispatcher("/WEB-INF/stock/textlogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("stock login post....");

        String sid = req.getParameter("sid");
        String spw = req.getParameter("spw");

        String auto = req.getParameter("auto");

        try {
            StockMemberDTO stockMemberDTO = StockMemberService.INSTANCE.login(sid, spw);
            resp.sendRedirect("/stock/text");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
