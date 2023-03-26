import casket.Apple;
import casket.Box;
import casket.Orange;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Box<Apple> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();

        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());

        box2.add(new Apple());

        box3.add(new Orange());

        List<Apple> moreApples = new ArrayList<>();
        moreApples.add(new Apple());
        moreApples.add(new Apple());
        moreApples.add(new Apple());
        moreApples.add(new Apple());
        box2.addAll(moreApples);

        boolean res = box1.compare(box2);
        System.out.println("Коробка 1 дорівнюе коробці 3: " + res);

        float appleBoxW = box1.getWeight();
        System.out.println("Вага коробки1 з яблуками " + appleBoxW);

        float appleBoxW3 = box2.getWeight();
        System.out.println("Вага коробки 2 з яблуками " + appleBoxW3);

    }
}