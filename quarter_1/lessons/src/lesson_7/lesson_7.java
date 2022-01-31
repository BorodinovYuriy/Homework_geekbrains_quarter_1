package lesson_7;
/**
 * 1-При отрицательных значениях в миске котики считают, что миска пуста.
 * 2-добавлено поле сытость (boolean satiety)
 * 3-коты отказываются от еды, если им мало
 * 4-массив котов создан, всё работает
 * 5-метод добавления еды в тарелку addFood() -плюсует к food /....
 * ---добавил альтернативную реализацию метода info
 * (без прямой печати в консоль)
 * */
public class lesson_7 {
    public static void main(String[] args) {

        HungryCat cat_1 = new HungryCat("Паштет", 20);
        HungryCat cat_2 = new HungryCat("Закуска", 10);
        HungryCat cat_3 = new HungryCat("Шаверма", 15);
        HungryCat cat_4 = new HungryCat("Валет", 5);

        Plate plate_1 = new Plate(10,"Миска с мышатами");
        plate_1.printInfo();
        plate_1.addFood(30);
        plate_1.printInfo();

            System.out.println("\nВыполняем массив:\n");

        HungryCat[] cats = {cat_1,cat_2,cat_3,cat_4};
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate_1);
            System.out.println();
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName()+" "+cats[i].isSatiety());
        }
        System.out.println();

        System.out.println(cat_1.catFullInfo());
        System.out.println();
        System.out.println(plate_1.plateFullInfo());
    }
}
