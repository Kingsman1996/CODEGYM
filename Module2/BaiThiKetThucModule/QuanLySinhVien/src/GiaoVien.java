public class GiaoVien extends Nguoi {
    private int maGiaoVien;

    public GiaoVien() {
    }

    public GiaoVien(String ten, String ngaySinh, String gioiTinh, String soDienThoai, int maGiaoVien) {
        super(ten, ngaySinh, gioiTinh, soDienThoai);
        this.maGiaoVien = maGiaoVien;
    }

    @Override
    public String toString() {
        return maGiaoVien + "," + super.toString();
    }
}
