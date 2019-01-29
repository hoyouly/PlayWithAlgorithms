package top.hoyouly.playwithalgorithms.chapter7;


import java.util.ArrayList;

public class Chap7Test {

    public static void main(String[] args) {
//        testBSTSet();
//        testLinkedListSet();

//        testLinkedListMap();
        testBSTMap();
    }

    private static void testBSTMap() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        BSTMap<String, Integer> map = new BSTMap<>();
        for (String s : list) {
            if (map.contains(s)) {
                map.set(s, map.get(s) + 1);
            } else {
                map.add(s, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride : " + map.get("pride"));
        System.out.println("Frequency of prejudice :  " + map.get("prejudice"));

    }

    private static void testLinkedListMap() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        for (String s : list) {
            if (map.contains(s)) {
                map.set(s, map.get(s) + 1);
            } else {
                map.add(s, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride : " + map.get("pride"));
        System.out.println("Frequency of prejudice :  " + map.get("prejudice"));

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
