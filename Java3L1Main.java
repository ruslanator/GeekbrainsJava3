package Java3L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Java3L1Main {
    public static void main(String[] args){
        // 1.
        String[] stringArr = {"apple", "banana", "cucumber", "tomato", "orange"};
        System.out.println("Task one");
        System.out.println(Arrays.toString(stringArr));
        swapArrayElements(stringArr, 0, 3);
        System.out.println(Arrays.toString(stringArr));

        // 2.
        System.out.println("Task two");
        Integer[] intArr = {1, 2, 3, 5};
        System.out.println(Arrays.toString(intArr));
        List<Integer> list = arrToArrayList(intArr);
        System.out.println(list);

        // 3.
        System.out.println("Task three");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3, apple4, apple5, apple6);
        Box<Orange> box2 = new Box<Orange>(orange1, orange2, orange3, orange4);

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();
        box2.transfer(box3);

    }
    // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
    private static <E>  void swapArrayElements(E[] arr, int firstIndex, int secondIndex){
        E buffer = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = buffer;
    }
    // 2. Написать метод, который преобразует массив в ArrayList
    private static <T> ArrayList arrToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
    //3. Большая задача:
    //a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
    //b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
    //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    //g. Не забываем про метод добавления фрукта в коробку.

    public static abstract class Fruit {
        protected float weight;

        public Fruit(float weight) {
            this.weight = weight;
        }

        public float getWeight() {
            return weight;
        }
    }

    public static class Apple extends Fruit {
        public Apple() {
            super(1f);
        }
    }
    public static class Orange extends Fruit {
        public Orange() {
            super(1.5f);
        }
    }

    public static class Box<T extends Fruit> {
        private ArrayList<T> fruits;

        public Box(T... items) {
            this.fruits = new ArrayList<T>(Arrays.asList(items));
        }

        public void clear() {
            fruits.clear();
        }

        public float getWeight() {
            if (fruits.size() == 0){
                return 0;
            }
            float weight = 0;
            for (T item: fruits){
                weight += item.getWeight();
            }
            return weight;
        }

        public boolean compare(Box box) {
            return this.getWeight() == box.getWeight();
        }

        public void transfer(Box<? super T> box) {
            box.fruits.addAll(this.fruits);
            clear();
        }
    }
}
