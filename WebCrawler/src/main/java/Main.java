import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
//        url here
        String url = "https://www.behance.net/galleries";
        try {
            // Get Document
            //This will get cookies

            Document document = Jsoup.connect(url)
                    .referrer("https://accounts.pixiv.net/")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36")
                    .cookie("Cookie","_gid=GA1.2.161655194.1655172927; _gat_UA-1830249-3=1; first_visit_datetime_pc=2022-06-14+11%3A15%3A26; p_ab_id=6; p_ab_id_2=0; p_ab_d_id=123681632; yuid_b=ITCVZ0E; _gcl_au=1.1.353203878.1655172927; __utma=235335808.700388770.1654834697.1655172927.1655172927.1; __utmc=235335808; __utmz=235335808.1655172927.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __cf_bm=IXvUMOtWomKWFlnBJjUpBg1oZWd59YMron89Gt2D7TU-1655172927-0-AfJaOMLhhI7iMlslYJoDerlA81zJKow8RJWY0UmW5nXKFFGH9p8EVJUC6nJrs5ENfLMlMSrAMsfzMpTufow9SoR3KXI2nJ+v2h0nYBnS2B/8ABkRE2Od0MZYVwbUY7YvnPYkNoDNjG1R/NgmZpb+enMGuv9p8oVvN19Zh+wd2fBLog0GND7gAQ7Nxanln5g8dg==; _gat=1; PHPSESSID=82624367_zBf4L1uYatkqIOyaHOtFDqp4Yc6H1Zr4; device_token=d4393638d3f586c89889b5d46d7a2265; privacy_policy_agreement=3; c_type=21; privacy_policy_notification=0; a_type=0; b_type=1; _gat_UA-76252338-1=1; __utmv=235335808.|2=login%20ever=no=1^3=plan=normal=1^5=gender=male=1^6=user_id=82624367=1^9=p_ab_id=6=1^10=p_ab_id_2=0=1^11=lang=zh=1; _ga_75BBYNYN9J=GS1.1.1655171309.4.1.1655172947.0; __utmb=235335808.2.10.1655172927; QSI_S_ZN_5hF4My7Ad6VNNAi=r:10:1; _ga=GA1.2.700388770.1654834697")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .timeout(10000)
                    .get();
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
            }
            System.out.println("Finish downloading");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}