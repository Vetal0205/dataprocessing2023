package Servlets;


import Crud.Lab2CrudInterface;
import Entities.Manpads;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manpads")
public class ManpadsServlet extends HttpServlet {
    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;
    public ManpadsServlet() {
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
//      new Manpads("Blowpipe", 2.2, "./assets/img/blowpipe.png");
//      new Manpads("Igla", 1.3, "./assets/img/igla.png");
//      new Manpads("FIM-43 Redeye", 1.0, "./assets/img/redeye.png");
//      new Manpads("FIM-92 Stinger", 2.3, "./assets/img/stinger.png");
//      new Manpads("Javelin", 2.2, "./assets/img/javelin.png");
        String someJson = new Gson().toJson(lab2Crud.readData());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
    @Override
    public void doPut(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String photo = request.getParameter("photo");
        double weight = Double.parseDouble(request.getParameter("weight"));
        lab2Crud.addData(new Manpads(name,weight,photo));
    }
}
