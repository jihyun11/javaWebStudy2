package org.zerock.w2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dao.StockMemberDAO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.dto.StockMemberDTO;
import org.zerock.w2.service.MemberService;
import org.zerock.w2.service.StockMemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

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

        boolean rememberMe = auto != null && auto.equals("on");

        try {

            StockMemberDTO stockMemberDTO = StockMemberService.INSTANCE.login(sid, spw);

            if (rememberMe) {
                String uuid = UUID.randomUUID().toString();

                StockMemberService.INSTANCE.StockuUpdateUuid(sid, uuid);
                stockMemberDTO.setUuid(uuid);

                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60*60*24*7); //쿠키유효기간1주일
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", stockMemberDTO);
            resp.sendRedirect("/stock/text");

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}


