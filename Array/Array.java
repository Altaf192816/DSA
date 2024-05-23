import java.util.ArrayList;
import java.util.Scanner;

public class Array {
    public static void delElOfArr(int arr[], int len, int deleteEl) {
        if (arr[len - 1] == deleteEl) {
            arr[len - 1] = 0;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == deleteEl) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
    }

    public static int maxArrEl(int arr[], int len) {
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }
//    public static int secondLargestEl(int arr[],int len){
//        int max = maxArrEl(arr,arr.length);
//        int secondLrgEl = 0;
//        for (int i = 0; i < len; i++) {
//            if((secondLrgEl<arr[i]) && !(arr[i] = max)){
//
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*-----------------------------------Todo:-Delete a element in array---------------------------------------------*/
        int[] arr = {3, 8, 12, 5, 6};
//        int deleteEl = scan.nextInt();
//        delElOfArr(arr, arr.length, deleteEl);
//        for (int el : arr) {
//            System.out.print(el + " ");
//        }

        System.out.println(maxArrEl(arr,arr.length));

    }
}
