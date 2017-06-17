package yrostami.controller;

import org.apache.commons.codec.binary.Base64;
import yrostami.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by Yousef on 06/16/2017.
 */
@WebServlet(name = "ResultsFile")
public class ResultsFile extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        Boolean authenticated = (Boolean)req.getSession().getAttribute("Authenticated");

        if (authenticated == null || authenticated.equals(Boolean.FALSE)) {
            res.sendRedirect("/");
            return;
        }

        res.addHeader("Content-Disposition", "attachment; filename=\"results-file-"
                +new Date(System.currentTimeMillis()).toString()+".xlsx\"");
        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        res.setHeader("Expires:", "0");
        byte[] bytes = Service.getXLSFile();
        res.setContentLength(bytes.length);
        OutputStream out = res.getOutputStream();
        out.write(bytes);
        out.flush();
    }
}
