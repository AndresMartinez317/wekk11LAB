import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter a city");
        String country = s.nextLine();
        //https://api.api-ninjas.com/v1/historicalevents?text=colombia
        //xdhBTu8kP/E6NQ+ldyRsVA==janbDkuslSzoBlmv
        try {
            URL url = new URL("http://universities.hipolabs.com/search?country="+country);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200){
                throw new RuntimeException("ocurrio un error "+ responseCode);
            }else{
                StringBuilder infostring = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext()){
                    infostring.append("\n");
                    infostring.append(sc.nextLine());

                }
                sc.close();
                System.out.println(infostring);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}