import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập URL file cần tải: ");
        String fileURL = scanner.nextLine();

        Downloader downloader = new FileDownloaderProxy();

        try {
            downloader.download(fileURL);
        } catch (IOException e) {
            System.err.println("Lỗi khi tải file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
