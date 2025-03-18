import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LopHoc lopHoc = new LopHoc();
        lopHoc.setGiaoVien(new GiaoVien("Le Nhu Nguyet", "10/10/1990", "Nu", "0969181196", 1));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            xemMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhap ten sinh vien");
                    String ten = scanner.nextLine();
                    while (!Validate.tenHopLe(ten)) {
                        ten = scanner.nextLine();
                    }
                    System.out.println("Nhap ngay sinh");
                    String ngaySinh = scanner.nextLine();
                    while (!Validate.ngaySinhHopLe(ngaySinh)) {
                        System.out.println("Ngay sinh khong hop le");
                        ngaySinh = scanner.nextLine();
                    }
                    System.out.println("Nhap gioi tinh");
                    String gioiTinh = scanner.nextLine();
                    System.out.println("Nhap so dien thoai");
                    String soDienThoai = scanner.nextLine();
                    while (!Validate.soDienThoaiHopLe(soDienThoai)) {
                        soDienThoai = scanner.nextLine();
                    }
                    System.out.println("Nhap ma lop hoc");
                    String maLopHoc = scanner.nextLine();
                    while (!lopHoc.docFile("data/batchs.csv").contains(maLopHoc)) {
                        System.out.println("Khong tim thay ma lop hoc, nhap lai");
                        maLopHoc = scanner.nextLine();
                    }
                    SinhVien sinhVien = new SinhVien(ten, ngaySinh, gioiTinh, soDienThoai, maLopHoc);
                    lopHoc.themSinhVien(sinhVien);
                    lopHoc.ghiFile("data/students.csv");
                    break;
                case 2:
                    if (lopHoc.getSinhViens().isEmpty()) {
                        System.out.println("Danh sach trong");
                        break;
                    }
                    System.out.println("Nhap id sinh vien");
                    int id = scanner.nextInt();
                    while (true) {
                        try {
                            if (Validate.idHopLe(id)) {
                                break;
                            }
                        } catch (NotFoundStudentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    lopHoc.xoaSinhVien(String.valueOf(id));
                    break;
                case 3:
                    lopHoc.xemNhieuSinhVien();
                    break;
                case 4:
                    lopHoc.xemGiaoVien();
                    break;
                case 5:
                    if (lopHoc.docFile("data/students.csv").isEmpty()) {
                        System.out.println("Danh sach trong");
                        break;
                    }
                    System.out.println("Nhap ten sinh vien");
                    ten = scanner.nextLine();
                    boolean flag = false;
                    for (String line : lopHoc.docFile("data/students.csv")) {
                        if (line.contains(ten)) {
                            flag = true;
                            System.out.println(line);
                        }
                    }
                    if (!flag) {
                        System.out.println("Khong tim thay sinh vien");
                    }
                    break;
            }
        }
    }

    public static void xemMenu() {
        System.out.println("1. Them sinh vien");
        System.out.println("2. Xoa sinh vien");
        System.out.println("3. Xem danh sach sinh vien");
        System.out.println("4. Xem giao vien");
        System.out.println("5. Tim kiem sinh vien");
        System.out.println("6. Thoat");
    }
}