package Animal;
import edible.edible;
public class Chicken extends Animal implements edible{
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    public String howToEat() {
        return "could be fried";
    }
}
