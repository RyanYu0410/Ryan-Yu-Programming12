import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // 利用Jsoup获得连接
        Connection connect = Jsoup.connect("https://www.wallpaper.com/");
        try {
            // 得到Document对象
            Document document = connect.get();
            // 查找所有img标签`
            Elements imgs = document.getElementsByTag("img");
            System.out.println("共检测到下列图片URL：");
            System.out.println("开始下载");
            // 遍历img标签并获得src的属性
            for (Element element : imgs) {
                //获取每个img标签URL "abs:"表示绝对路径
                String imgSrc = element.attr("abs:src");
                // 打印URL
                System.out.println(imgSrc);
                //下载图片到本地
                DownloadImage.DownloadImages("d:/img", imgSrc);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
