package exp11;

import java.util.LinkedList;
import java.util.Scanner;
class DuplicateList {
    LinkedList<Integer> list;
    DuplicateList() {
        list = new LinkedList<>();
    }
    DuplicateList(LinkedList<Integer> list) {
        this.list = list;
    }
    void removeDuplicates() {
        LinkedList<Integer> newList = new LinkedList<>();
        for (Integer num : list) {
            boolean found = false;
            for (Integer x : newList) {

                if (x.equals(num)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                newList.add(num);
            }
        }
        list = newList;
    }
    public String toString() {
        return "Linked List: " + list;
    }
}
public class LinkedListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        DuplicateList obj = new DuplicateList(list);
        System.out.println("Before Removing Duplicates:");
        System.out.println(obj);
        obj.removeDuplicates();
        System.out.println("After Removing Duplicates:");
        System.out.println(obj);
    }
}