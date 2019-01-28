package top.hoyouly.playwithalgorithms.chapter7;


import java.util.ArrayList;

public class Chap7Test {

    public static void main(String[] args) {
//        testBSTSet();
            testLinkedListSet();
    }

    private static void testLinkedListSet() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        LinkedListSet<String> bstSet = new LinkedListSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("\n a-tale-of-two-cities: ");
        list = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", list);
        System.out.println("Total words: " + list.size());

        bstSet = new LinkedListSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());
    }


    private static void testBSTSet() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        BSTSet<String> bstSet = new BSTSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("\n a-tale-of-two-cities: ");
        list = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", list);
        System.out.println("Total words: " + list.size());

        bstSet = new BSTSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());
    }


}
