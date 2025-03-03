import java.io.*;
import java.util.Scanner;

public class FileCopier {
    public static void copyFile(String source, String destination) throws IOException {
        File src = new File(source);
        File des = new File(destination);
        if (!src.exists()) {
            throw new FileNotFoundException("File nguồn không tồn tại!");
        }
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(des)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file nguồn");
        String source = sc.nextLine();
        System.out.println("Nhập đường dẫn file đích");
        String destination = sc.nextLine();
        try {
            copyFile(source, destination);
            System.out.println("Sao chép file thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }
}
