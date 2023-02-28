package Servlets;
import java.util.Iterator;
import java.io. IOException;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta. servlet .http.HttpServletRequest;
import Entities.Manpads;

public class Helper {
    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;
        try {
            jsonElement = JsonParser.parseReader(request.getReader());

        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return jsonElement;
    }
    public static int idParse(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("id"));
    }
    public static boolean hibernateParse(HttpServletRequest request) {
        return Boolean.parseBoolean(request.getParameter("hibernate"));
    }
    public static Manpads userParse(HttpServletRequest request) {
        Manpads manpad = new Manpads();
        JsonElement jsonElement = bodyParse(request);
        manpad.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        manpad.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        manpad.setPhoto(jsonElement.getAsJsonObject().get("photo").getAsString());
        manpad.setWeight(jsonElement.getAsJsonObject().get("weight").getAsDouble());
        return manpad;
    }
    public static int getNextId(List<Manpads> list) {
        int maxId = 0;
        if (list == null){
            return 0;
        }
        for (Manpads manpads : list) {
            int currentId = manpads.getId();
            if (currentId > maxId) maxId = currentId;
        }
        return maxId+1;
    }
    public static int getIndexByUserId(int id,  List<Manpads> list){
        int listId = id;
        if (list == null){
            return -1;
        }
        for (Manpads temp : list) {
            if (temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}