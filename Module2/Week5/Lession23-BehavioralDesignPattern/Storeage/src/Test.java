public class Test {
    public static void main(String[] args) {
        User user = new User();
        UserController userController = new UserController(new XMLStorage());
        userController.store(user);

        userController.setStorage(new MySQLStorage());
        userController.store(user);
    }
}
