import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Using JSoup
        Connection connect = Jsoup.connect("https://www.nike.com/ca/w/lifestyle-shoes-13jrmzy7ok");
        try {
            // Get Document
            Document document = connect.get();
            // Find img tag
            Elements imgs = document.getElementsByTag("img");
            System.out.println("img URL：");
            System.out.println("Start downloading");
            // Find src in img tag
            for (Element element : imgs) {
                //URL "abs:"
                String imgSrc = element.attr("abs:src");
                // Print URL
                System.out.println(imgSrc);
                //Download img
                DownloadImage.DownloadImages("d:/img", imgSrc);
            }
            System.out.println("Finish downloading");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
