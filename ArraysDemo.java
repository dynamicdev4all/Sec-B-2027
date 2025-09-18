import java.util.Scanner;

public class ArraysDemo {
    static int arr[] = new int[5];

    static void insertData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Please enter the " + i + "value");
            arr[i] = sc.nextInt();
        }
    }

    static void showData() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    static void deleteData(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    static void updateData(int index, int data){
        arr[index]= data;
    }

    public static void main(String[] args) {
        insertData();
        showData();
        updateData(3, 100);
        showData();
        deleteData(2);
        showData();
    }
}
