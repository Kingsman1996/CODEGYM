package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: OOOOOO";
    }

    @Override
    public String howToEat() {
        return "Chicken: Fry me";
    }
}
