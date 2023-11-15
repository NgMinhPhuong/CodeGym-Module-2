import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Client {
    public static void main(String[] args) {
        Downloader downloader = new FileDownloaderProxy();
        downloader.download("https://filesamples.com/samples/document/txt/sample1.txt");

    }
}