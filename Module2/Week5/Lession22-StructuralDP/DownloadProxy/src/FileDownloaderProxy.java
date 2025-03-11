import java.io.IOException;

public class FileDownloaderProxy implements Downloader {
    private static final String FIREFOX_USER_AGENT = "Mozilla Firefox/110.0";
    private FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        this.fileDownloader = new FileDownloader(FIREFOX_USER_AGENT);
    }

    @Override
    public void download(String fileURL) throws IOException {
        fileDownloader.download(fileURL);
    }
}
