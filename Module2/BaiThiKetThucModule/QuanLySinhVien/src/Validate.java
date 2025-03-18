public class Validate {
    public static final String ID_HOCVIEN_REG = "^[0-9]+$";
    public static final String PHONE_REG = "^(090|091)\\d{7}$";
    public static final String NGAY_SINH = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

    public static boolean idHopLe(int id) {
        if (!String.valueOf(id).matches(ID_HOCVIEN_REG)) {
            throw new NotFoundStudentException();
        }
        return true;
    }

    public static boolean ngaySinhHopLe(String date) {
        return date.matches(NGAY_SINH);
    }

    public static boolean tenHopLe(String ten) {
        if (ten.length() > 50 || ten.length() < 4) {
            System.out.println("Ten sinh vien tu 4 den 50 ky tu");
            return false;
        }
        return true;
    }

    public static boolean soDienThoaiHopLe(String phoneNumber) {
        if (!phoneNumber.matches(PHONE_REG)) {
            System.out.println("Nhap so dien thoai hop le");
            return false;
        }
        return true;
    }
}
