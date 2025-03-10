public class AnimalFactory {
    public Animal makeAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("Dog")) {
            return new Dog();
        }
        if (animalType.equalsIgnoreCase("Cat")) {
            return new Cat();
        }
        throw new IllegalArgumentException("Invalid animal type: " + animalType);
    }
}
