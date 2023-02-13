package Servlets;


import Crud.Lab2CrudInterface;
import Entities.Manpads;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/manpads")
public class ManpadsServlet extends HttpServlet {
    List<Manpads> manpadsList;
    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;
    public ManpadsServlet() {
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        manpadsList = lab2Crud.readData();
        String someJson = new Gson().toJson(manpadsList);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
    @Override
    public void doPut(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Manpads manpad = Helper.userParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        int index = Helper.getIndexByUserId(id, manpadsList);
        manpadsList.set(index, manpad);
        lab2Crud.addData(manpadsList);
        doGet(request,response);
    }
    @Override
    public void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        Manpads manpad = Helper.userParse(request);
        manpad.setId(Helper.getNextId(manpadsList));
        manpadsList.add(manpad);
        lab2Crud.addData(manpadsList);
        doGet(request,response);
    }
    @Override
    public void doDelete(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        int index = Helper.getIndexByUserId(id, manpadsList);
        manpadsList.remove(index);
        lab2Crud.addData(manpadsList);
        doGet(request,response);
    }
    @Override
    protected void doOptions(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException{
        setAccessControlHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }
    private void setAccessControlHeaders(@NotNull HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
