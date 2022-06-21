import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadImage {

    /**
     * DownloadImage to path
     *
     * @param filePath filepath
     * @param imgUrl   imgURL
     */
    public static void DownloadImages(String filePath, String imgUrl) {
        // If path exist otherwise create
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // img name
        String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1, imgUrl.length());

        // Using URLEncoder to change space to +
        String urlTail = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        // UTF-8 format + to %20
        imgUrl = imgUrl.substring(0, imgUrl.lastIndexOf('/') + 1) + urlTail.replaceAll("\\+", "\\%20");

        // Print Path
        File file = new File(filePath + File.separator + fileName);

        try {
            // Get img URL
            URL url = new URL(imgUrl);
            // Create Connection
            URLConnection connection = url.openConnection();
            // Set 10 s connection time
            connection.setConnectTimeout(10 * 1000);
            // get Input Stream
            InputStream in = connection.getInputStream();
            // get Output Stream
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            // Create buffer
            byte[] buf = new byte[1024];
            int size;
            // write to file
            while (-1 != (size = in.read(buf))) {
                out.write(buf, 0, size);
            }
            out.close();
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
