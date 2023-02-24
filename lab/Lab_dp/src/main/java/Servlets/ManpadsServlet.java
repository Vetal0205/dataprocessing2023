package Servlets;

import Crud.LabCRUDInterface;
import Entities.Manpads;
import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manpads/*")
public class ManpadsServlet extends HttpServlet {
    ManpadsServletConfigInterface servletConfig;
    LabCRUDInterface<Manpads> CRUD;
    public ManpadsServlet() {
        this.servletConfig = new ManpadsServletConfig();
        this.CRUD = servletConfig.getSqlCRUD();
    }
    public void init(ServletConfig config) throws ServletException{
        this.servletConfig = new ManpadsServletConfig();
        this.CRUD = servletConfig.getSqlCRUD();
    }
    public void destroy(){
        this.servletConfig.CloseConnection();
    }
    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        String someJson = new Gson().toJson(CRUD.read());
        System.out.println(someJson);
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
//        int id = Integer.parseInt(request.getPathInfo().substring(1));
//        int index = Helper.getIndexByUserId(id, manpadsList);
//        manpadsList.set(index, manpad);
        CRUD.update(manpad.getId(), manpad);
        doGet(request,response);
    }
    @Override
    public void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        Manpads manpad = Helper.userParse(request);
//        manpad.setId(Helper.getNextId(manpadsList));
//        manpadsList.add(manpad);
        CRUD.create(manpad);
        System.out.println(manpad.getName());
        System.out.println(manpad.getWeight());

        doGet(request,response);
    }
    @Override
    public void doDelete(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
//        int index = Helper.getIndexByUserId(id, manpadsList);
//        manpadsList.remove(index);
        CRUD.delete(id);
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
