public class SinhVien extends Nguoi {
    private static int count = 0;
    private int maSinhVien;

    private String maLopHoc;

    public SinhVien(String ten, String ngaySinh, String gioiTinh, String soDienThoai, String maLopHoc) {
        super(ten, ngaySinh, gioiTinh, soDienThoai);
        this.maSinhVien = ++count;
        this.maLopHoc = maLopHoc;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SinhVien.count = count;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    @Override
    public String toString() {
        return maSinhVien + "," + maLopHoc + "," + super.toString();
    }
}
