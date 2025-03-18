import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LopHoc {
    private String maLop;
    private String tenLop;
    private GiaoVien giaoVien;
    private List<SinhVien> sinhViens;

    public LopHoc() {
        sinhViens = new ArrayList<>();
    }

    public LopHoc(String maLop, String tenLop, String maGiaoVien) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.giaoVien = new GiaoVien();
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public void setSinhViens(List<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public void themSinhVien(SinhVien sinhVien) {
        sinhViens.add(sinhVien);
    }

    public void xoaSinhVien(String id) {
        if (docFile("data/students.csv").isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            for (String line : docFile("data/students.csv")) {
                if (line.split(",")[0].equals(id)) {
                    int foundIndex = Integer.parseInt(id) - 1;
                    SinhVien found = sinhViens.get(foundIndex);
                    sinhViens.remove(found);
                    ghiFile("data/students.csv");
                }
                System.out.println(line);
            }
        }
    }

    public void xemNhieuSinhVien() {
        if (docFile("data/students.csv").isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            for (String line : docFile("data/students.csv")) {
                System.out.println(line);
            }
        }
    }

    public void xemGiaoVien() {
        System.out.println(giaoVien.toString());
    }

    public void ghiFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (SinhVien item : sinhViens) {
                writer.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> docFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
