package yrostami.controller;

import yrostami.service.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yousef.
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        if (user == null || user.isEmpty() || pass == null || pass.isEmpty()) {
            req.setAttribute("msg", "نام کاربری و گذرواژه را وارد کنید.");
            res.sendRedirect("/");
        } else {
            if (DataBase.isValidUser(user, pass)) {
                req.getSession(true).setAttribute("Authenticated", Boolean.TRUE);
                req.getRequestDispatcher("/download.jsp").forward(req, res);
            } else {
                req.setAttribute("msg", "نام کاربری یا گذرواژه اشتباه است.");
                res.sendRedirect("/");
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/");
            res.setStatus(401);
            return;
        }

        Boolean authenticated = (Boolean) session.getAttribute("Authenticated");
        if(authenticated == null || authenticated.equals(Boolean.FALSE)){
            res.sendRedirect("/");
            res.setStatus(401);
            return;
        }

        req.getRequestDispatcher("/download.jsp").forward(req,res);
    }
}
