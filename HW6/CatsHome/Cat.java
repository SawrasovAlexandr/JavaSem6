package CatsHome;

import java.util.concurrent.TimeUnit;

public class Cat {

    private String name;
    private int appetite;
    private int satiety = 5;

    public Cat(String name) {
        this(name, 30);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                satiety -= 1;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (satiety <= appetite / 2) {
            satiety += plate.decreaseFood(appetite - satiety);
        }
    }


    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
