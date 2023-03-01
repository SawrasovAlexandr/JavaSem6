package CatsHome;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
        } else {
            foodToDecrease = food;
            food = 0;
        }
        return foodToDecrease;
    }

    public void increaseFood (int foodToIncrease) {
        food = food + foodToIncrease;
    }

    public boolean isEmpty() {
        if (food > 0) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
