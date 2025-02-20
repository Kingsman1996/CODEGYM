import animal.Animal;
import animal.Chicken;
import animal.Tiger;
import fruit.Fruit;
import fruit.Apple;
import fruit.Orange;
import edible.Edible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        Fruit[] fruits = new Fruit[2];
        animals[0] = new Chicken();
        animals[1] = new Tiger();
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (int i = 0; i < 2; i++) {
            System.out.println(animals[i].makeSound());
            if (animals[i] instanceof Chicken) {
                System.out.println(animals[i].howToEat());
            }
            System.out.println(fruits[i].howToEat());
        }
    }
}
