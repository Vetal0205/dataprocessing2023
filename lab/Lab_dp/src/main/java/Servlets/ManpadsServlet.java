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
    static ManpadsServletConfigInterface servletConfig;
    static LabCRUDInterface<Manpads> jdbcCRUD;
    static LabCRUDInterface<Manpads> jpaCRUD;
    public ManpadsServlet() {
        servletConfig = new ManpadsServletConfig();
        jdbcCRUD = servletConfig.getJdbcCrud();
        jpaCRUD = servletConfig.getJpaCrud();
    }
    public void init(ServletConfig config) throws ServletException{
        servletConfig = new ManpadsServletConfig();
        jdbcCRUD = servletConfig.getJdbcCrud();
        jpaCRUD = servletConfig.getJpaCrud();
    }
    public void destroy(){
        servletConfig.CloseJdbcConnection();
        servletConfig.CloseJpaConnection();
    }
    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        String someJson = new Gson().toJson(jdbcCRUD.read());
        System.out.println(someJson);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.flush();
    }
    @Override
    public void doPut(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Manpads manpad = Helper.userParse(request);
        if (Helper.hibernateParse(request)){
            jpaCRUD.update(manpad.getId(), manpad);
        }
        else {
            jdbcCRUD.update(manpad.getId(), manpad);
        }
        doGet(request,response);
    }
    @Override
    public void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        Manpads manpad = Helper.userParse(request);
        if (Helper.hibernateParse(request)){
            jdbcCRUD.create(manpad);
        }
        else {
            jpaCRUD.create(manpad);
        }
        doGet(request,response);
    }
    @Override
    public void doDelete(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        System.out.println(request);
        if (Helper.hibernateParse(request)){
            jpaCRUD.delete(Helper.idParse(request));
        }
        else {
            jdbcCRUD.delete(Helper.idParse(request));
        }
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
