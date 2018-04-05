import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Scrapper {

    public static void main(String[] args) throws IOException {

        String url = "https://www.numbeo.com/pollution/in/Delhi";
        Document doc = Jsoup.connect(url).get();
        //String content = doc.toString();

        Elements getWho = doc.getElementsByClass("who_pollution_data_widget");

        for (Element elements:getWho
             ) {
            Files.write(Paths.get("./pollutionWho.txt"),elements.text().getBytes());
            System.out.println(elements.text());
           // System.out.print("sometext");
        }

        //Element ele = doc.getElementById("safe_alone_daylight");

        //String txt = ele.text();

        //Files.write(Paths.get("./elemetsID.txt"),txt.getBytes());


    }

}
