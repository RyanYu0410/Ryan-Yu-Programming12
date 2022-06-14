import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class jsoupLogin {

    /**
     * Jsoup Simulate Login
     * Get cookies from a wrong account num
     * Get cookies
     * Set request cookies, request again
     * @param loginUrl Login Url
     * @param userInfoUrl Personal Info Url
     * @throws IOException
     */
    public jsoupLogin(String loginUrl, String userInfoUrl)  throws IOException {

        // 构造登陆参数
        Map<String,String> data = new HashMap<>();
        data.put("name","your_account");
        data.put("password","your_password");
        data.put("remember","false");
        data.put("ticket","");
        data.put("ck","");
        Connection.Response login = Jsoup.connect(loginUrl)
                .ignoreContentType(true)
                .followRedirects(false)
                .postDataCharset("utf-8")
                .header("Upgrade-Insecure-Requests","1")
                .header("Accept","application/json")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("X-Requested-With","XMLHttpRequest")
                .header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
                .data(data)
                .method(Connection.Method.POST)
                .execute();
        login.charset("UTF-8");
        // login 中已经获取到登录成功之后的cookies
        // 构造访问个人中心的请求
        Document document = Jsoup.connect(userInfoUrl)
                // 取出login对象里面的cookies
                .cookies(login.cookies())
                .get();

        if (document != null) {
            Element element = document.select(".info h1").first();
            if (element == null) {
                System.out.println("Can't find .info h1 TAG");
                return;
            }
            String userName = element.ownText();
            System.out.println(userName);
        } else {
            System.out.println("出错啦！！！！！");
        }
    }
}
