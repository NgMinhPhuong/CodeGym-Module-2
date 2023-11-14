public class FactoryDemo {
    public static void main(String[] args) {
        FactoryAnimal animalFactory = new FactoryAnimal();

        Animal a1 = animalFactory.getAnimal("feline");
        System.out.println("a1 sound: " + a1.makeSound());

        Animal a2 = animalFactory.getAnimal("canine");
        System.out.println("a2 sound: " + a2.makeSound());
    }
}
