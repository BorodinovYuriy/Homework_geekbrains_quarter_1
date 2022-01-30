package lesson_6;

public abstract class Animals {
    final int animalId;
    private static int animalCount = 0;
    protected String name;

    public Animals(String name) {
        this.name = name;
        animalId = animalCount + 1;
        animalCount++;
    }

    public abstract void run(double runMetre);

    public abstract void swim(double swimMetre);

    public void getID() {
        System.out.println("ID животного "+ name
                +": " + animalId);
    }
    public static void countAllAnimals() {
        System.out.println("Всего в нашем зверинце: "
                + animalCount +" животных");
    }
}

