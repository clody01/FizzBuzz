package tv.spideo.recruitment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("fizz-buzz")
public class FizzBuzzWs {

    @GET
    @Path("{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFizzBuzz(@PathParam("key") int key) {
        return "{\"resultat\":\"" + matchFizzBuzz(key) + "\"}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postFizzBuzz(String stringObject) {
        JSONObject jsonObject = new JSONObject(stringObject);
        String from = jsonObject.getString("from");
        String to = jsonObject.getString("to");
        String retour = "{\"resultats\":[]}";
        LinkedList<String> listefizzbuzz = new LinkedList<>();
        if (!"NoN".equals(to)) {
            int started = Integer.parseInt(from);
            int ended = Integer.parseInt(to);
            if (Math.abs(ended) >= Math.abs(started)) {
                for (int i = Math.abs(started); i <= Math.abs(ended); i++) {

                    listefizzbuzz.add("\"" + matchFizzBuzz(i) + "\"");
                }
                retour = "{\"resultats\":" + listefizzbuzz.toString() + "}";
            }
        }

        return retour;
    }

    public String matchFizzBuzz(int value) {
        String fizzbuzzResult = Integer.toString(value);
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(3, "Fizz");
        map.put(5,  "Buzz");
        map.put(7, "Quxx");
        map.put(11, "Vitt");
         
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String valeur = entry.getValue();
            if (value % key == 0) {
                fizzbuzzResult = valeur;
                return fizzbuzzResult;
            }
            
        }
       
        return fizzbuzzResult;
    }
}
