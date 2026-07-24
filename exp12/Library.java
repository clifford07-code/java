package exp12;

import java.io.*;
import java.util.*;
class Member {
    private int memberId;
    private String name;
    private int booksIssued;
    Member() {
        memberId = 0;
        name = "";
        booksIssued = 0;
    }
    Member(int memberId, String name, int booksIssued) {
        this.memberId = memberId;
        this.name = name;
        this.booksIssued = booksIssued;
    }
    public int getBooksIssued() {
        return booksIssued;
    }
    public String toString() {
        return "Member ID: " + memberId +
                "\nName: " + name +
                "\nBooks Issued: " + booksIssued;
    }
}
public class Library {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("exp12/member.txt"));
        int n = Integer.parseInt(file.nextLine());
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            int id = Integer.parseInt(file.nextLine());
            String name = file.nextLine();
            int books = Integer.parseInt(file.nextLine());
            members[i] = new Member(id, name, books);
        }
        PrintWriter out = new PrintWriter("exp12/member_output.txt");
        out.println("Members who issued more than 3 books");
        for (Member m : members) {
            if (m.getBooksIssued() > 3) {
                out.println(m);
                out.println();
            }
        }
        out.close();
        file.close();
        System.out.println("Data written to member_output.txt");
    }
}