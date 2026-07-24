package exp4;
import java.util.*;

class Member {
    private int memberId;
    private String name;
    private int booksIssued;

    public Member() {
        memberId = 0;
        name = "";
        booksIssued = 0;
    }

    public Member(int memberId, String name, int booksIssued) {
        this.memberId = memberId;
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }

    public String toString() {
        return "Member ID: " + memberId +
               "\nName: " + name +
               "\nBooks Issued: " + booksIssued;
    }
}

public class Library {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of members: ");
        int n = sc.nextInt();

        Member[] members = new Member[n];

        for(int i = 0; i < n; i++) {

            members[i] = new Member();

            System.out.println("\nEnter member details:");

            System.out.print("ID: ");
            members[i].setMemberId(sc.nextInt());

            sc.nextLine();

            System.out.print("Name: ");
            members[i].setName(sc.nextLine());

            System.out.print("Books Issued: ");
            members[i].setBooksIssued(sc.nextInt());
        }

        System.out.println("\nMembers who issued more than 3 books:");

        for(Member m : members) {
            if(m.getBooksIssued() > 3) {
                System.out.println(m);
                System.out.println();
            }
        }
    }
}