import java.io.IOException;

public interface Downloader {
    void download(String fileURL) throws IOException;
}
