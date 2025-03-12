public class MySQLStorage implements Storage {
    @Override
    public void store(User user) {
        System.out.println("MySQL storage is called");
    }
}
