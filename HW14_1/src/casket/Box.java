package casket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }


    private void addFruit(T fruit) {
        if (fruits.size() == 0 || fruit.getClass() == this.fruits.get(0).getClass()) {
            this.fruits.add(fruit);
        } else {
            throw new IllegalArgumentException("Ви не можете додати " + fruit.getClass().getName() + " в бокс с " + fruits.get(0).getClass().getName());
        }
    }

    public void add(T fruit) {
        addFruit(fruit);
    }

    public void addAll(List<T> fruits) {
        for (T fruit : fruits) {
            add(fruit);
        }
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.00f;
        }

        float weight = 0.0f;

        for (Fruit fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;

    }

    public boolean compare(Box<?> anotheBox) {
        return Math.abs(this.getWeight() - anotheBox.getWeight()) < 0;
    }

    public void merge(Box<? extends Fruit> anotheBox) {
        if (!fruits.isEmpty() && !anotheBox.fruits.isEmpty()) {
            if (this.fruits.get(0).getClass() != anotheBox.fruits.get(0).getClass()) {
                throw new IllegalArgumentException("Різні типи фруктів");
            }
        }

        this.fruits.addAll((Collection<? extends T>) anotheBox.getFruits());

    }

    public ArrayList<T> getFruits(){
        return fruits;
    }


}
