package yrostami.controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import yrostami.entity.Result;
import yrostami.service.DataBase;
import yrostami.service.Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yousef.
 */
public class ResultController extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        Gson gson = new Gson();
        try {
            Result result = gson.fromJson(req.getReader(), Result.class);
            if(Service.isValidResult(result)){
                DataBase.saveResult(result);
                res.setStatus(HttpServletResponse.SC_OK);
            } else res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

        }catch (JsonSyntaxException e){
            res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            e.printStackTrace();
        }catch (JsonIOException e){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
