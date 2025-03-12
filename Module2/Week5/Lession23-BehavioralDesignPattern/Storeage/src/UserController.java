public class UserController implements Storage {
    private Storage storage;

    public UserController(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void store(User user) {
        storage.store(user);
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
