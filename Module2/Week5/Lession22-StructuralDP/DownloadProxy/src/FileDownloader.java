import java.io.IOException;

public class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String fileURL) throws IOException {
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Downloading from: " + fileURL);
    }
}
