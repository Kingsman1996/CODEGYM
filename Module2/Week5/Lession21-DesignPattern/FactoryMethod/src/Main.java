public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal animal1 = factory.makeAnimal("Dog");
        Animal animal2 = factory.makeAnimal("Cat");
        System.out.println(animal1.makeSound());
        System.out.println(animal2.makeSound());
    }
}
