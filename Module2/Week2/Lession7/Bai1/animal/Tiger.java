package animal;

import edible.Edible;

public class Tiger extends Animal {
    @Override
    public String makeSound() {
        return "Tiger: Roarrrrrr";
    }

    @Override
    public String howToEat() {
        return "Tiger: Don't eat tigers";
    }
}
