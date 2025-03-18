public class NotFoundStudentException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Sinh vien khong ton tai";
    }
}
