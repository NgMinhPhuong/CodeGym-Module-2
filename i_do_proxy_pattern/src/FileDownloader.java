import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String url) {
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", userAgent);

            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\i_do_proxy_pattern\\src\\fine.txt")) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, bytesRead));
                    out.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }



}
