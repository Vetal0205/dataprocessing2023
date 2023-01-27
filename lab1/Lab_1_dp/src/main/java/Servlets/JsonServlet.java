package Servlets;


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
public class JsonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        Manpads[] itemsArray = new Manpads[5];
        itemsArray[0] = new Manpads("Blowpipe", 2.2, "./assets/img/blowpipe.png");
        itemsArray[1] = new Manpads("Igla", 1.3, "./assets/img/igla.png");
        itemsArray[2] = new Manpads("FIM-43 Redeye", 1.0, "./assets/img/redeye.png");
        itemsArray[3] = new Manpads("FIM-92 Stinger", 2.3, "./assets/img/stinger.png");
        itemsArray[4] = new Manpads("Javelin", 2.2, "./assets/img/javelin.png");
        String someJson = new Gson().toJson(itemsArray);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
}
