import java.util.*;

public class BinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();

        String arr[] = new String[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr);

    

        System.out.print("Enter element to search: ");
        String k = sc.nextLine();

        int first = 0;
        int last = n - 1;
        int resultIndex = -1;

        while (first <= last) {
            int mid = (first + last) / 2;

            int res = k.compareTo(arr[mid]);

            if (res == 0) {
                resultIndex = mid;
                break;
            } 
            else if (res > 0) {
                first = mid + 1;
            } 
            else {
                last = mid - 1;
            }
        }

        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}