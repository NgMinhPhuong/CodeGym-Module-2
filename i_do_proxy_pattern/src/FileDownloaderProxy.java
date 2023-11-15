public class FileDownloaderProxy implements Downloader {

    private FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        String userAgent = "Siêu máy tính";
        fileDownloader = new FileDownloader(userAgent);
    }

    @Override
    public void download(String url) {
        fileDownloader.download(url);
    }
}
