import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static void printN_To_1(int num) {
        if (num == 0) return;
        System.out.println(num);
        printN_To_1(num - 1);
    }

    public static void print1_To_N(int num) {
        if (num == 0) return;
        print1_To_N(num - 1);
        System.out.println(num);
    }

    public static int factOptimise(int n, int k) {
        if (n == 1 || n == 0) return k;
        return factOptimise(n - 2, k * n * (n - 1));
    }

    public static int factOptimise2(int n, int k) {
        if (n == 1 || n == 0) return k;
        return factOptimise(n - 1, n * k);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int sumNatural(int n) {
        if (n == 0) return 0;
        return n + sumNatural(n - 1);
    }

    public static boolean isPalindrome(String str, int i, int len) {
        if (i >= len - 1) return true;
        if (str.charAt(i) != str.charAt(len - 1)) return false;
        return isPalindrome(str, i + 1, len - 1);
    }

    public static int sumOfDigit(int num, int sum) {
        if (num == 0) return sum;
        return sumOfDigit(num / 10, sum + num % 10);
    }

    public static int maxPieces(int n, int a, int b, int c) {
        //base Case
        if (n == 0) return 0;
        if (n < 0) return -1;
        //recursive case
        int res = Math.max(maxPieces(n - a, a, b, c), maxPieces(n - b, a, b, c));
        res = Math.max(res, maxPieces(n - c, a, b, c));
        if (res == -1) return -1;//corner case
        return res + 1;
    }

    public static void generateSubset(String str, String[] sub, int i) {
        if (i == str.length()) return;
        for (int j = 0; j < (1 << i); j++) {
            sub[(1 << i) + j] = sub[j] + str.charAt(i);
        }
        generateSubset(str, sub, i + 1);
    }

    public static void subSet(String str) {
        String[] sub = new String[1 << str.length()];
        sub[0] = "";
        generateSubset(str, sub, 0);
        for (String el : sub) {
            System.out.print(el + "\t");
        }
    }

    public static void subSetOptimise(String str, String curr, int i) {
        if (i == str.length()) {
            System.out.print(curr + "\t");
            return;
        }
        subSetOptimise(str, curr, i + 1);
        subSetOptimise(str, curr + str.charAt(i), i + 1);
    }

    public static void TOH(int n, char A, char B, char C) {
        //base case
        if (n == 0) return;
        // recursive case
        TOH(n - 1, A, C, B);
        System.out.println("Move Disc " + n + " from " + A + " to " + C);
        TOH(n - 1, B, A, C);
    }


    public static void jos(ArrayList<Integer> people, int index, int n, int k) {
        if (people.size() == 1) {
            return;
        }
        index = (index + k) % n;
        people.remove(index);
        jos(people, index, n - 1, k);

    }

    public static int josProblem(int n, int k) {
        ArrayList<Integer> peopleArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleArr.add(i, i + 1);

        }
        jos(peopleArr, 0, n, k - 1);
        return peopleArr.get(0);
    }

    public static int jos2(int n, int k) {
        if (n == 1) return 0;
        return (jos2(n - 1, k) + k) % n;
    }

    public static int josOptimise(int n, int k) {
        return jos2(n, k) + 1;
    }

    static int count = 0;

    public static void subSet(int arr[], int i, int sum, int node) {
        if (i == arr.length) {
            if (node == sum) count++;
            return;
        }
        subSet(arr, i + 1, sum, node);
        subSet(arr, i + 1, sum, node + arr[i]);
    }

    public static int subSetSum(int arr[], int sum) {
        subSet(arr, 0, sum, 0);
        return count;
    }

    public static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void permutateString(String s, int i) {
        if (i == s.length() - 1) {
            System.out.println(s);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            s = swap(s, i, j);
            permutateString(s, i + 1);
            s = swap(s, j, i);
        }
    }

    public static void permutateString2(String s, String asf) {
        if (s.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            String leftStr = s.substring(0, j);
            String rightStr = s.substring(j + 1);
            String combineSring = leftStr + rightStr;
            permutateString2(combineSring, asf + ch);
        }
    }

    public static int binarySearch(int arr[], int low, int high, int find) {
        if (low > high) return -1;
        if (find == arr[(low + high) / 2]) return (low + high) / 2;
        if (find > arr[(low + high) / 2]) low = ((low + high) / 2) + 1;
        if (find < arr[(low + high) / 2]) high = ((low + high) / 2) - 1;
        return binarySearch(arr, low, high, find);
    }

    public long[] getTriangle(long arr[], long n) {
        long arrTri[] = new long[(int) n - 1];
        for (int i = 0; i < n - 1; i++) {
            arrTri[i] = arr[i] + arr[i + 1];
        }
        getTriangle(arrTri, arrTri.length);
        return arrTri;
    }
    static int Sum(int n,int sum){
        if(n == 0) return sum;
        return Sum(n/10,n%10 + sum);
    }
    static int repeatedSumOfDigits(int N){
        // code here
        int ans = 0;
        while(N >= 10){
            ans= Sum(N,0);
            N = ans;
        }
        return N;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //---------------------------------Todo:-Print N to 1---------------------------------------------------
// *time-->O(n) space-->O(n)
//        printN_To_1(5);
        //---------------------------------Todo:-Topic---------------------------------------------------
// *time-->O(n) space-->O(n)
//        print1_To_N(4);
        //---------------------------------Todo:-factorial---------------------------------------------------
// *time-->O(n) space-->O(1)
//        System.out.println(factOptimise(2,1));
//        System.out.println(factOptimise2(2,1));
        //---------------------------------Todo:-Fibonacci---------------------------------------------------
//        System.out.println(fibonacci(6));
        //---------------------------------Todo:-Sum of n Natural number---------------------------------
// *time-->O(n) space-->O(n)
//        System.out.println(sumNatural(1));
        //---------------------------------Todo:-Palindrome---------------------------------------------------
// *time-->O(n) space-->O(n)
//        String str = scn.nextLine();
//        System.out.println(isPalindrome(str,0,str.length()));
        //---------------------------------Todo:Sum of digit----------------------------------------------------
// *time-->O(number of digit) space-->O(number of digit)
//        int num = scn.nextInt();
//        System.out.println(sumOfDigit(num, 0));
//        //---------------------------------Todo:Rope cutting problem----------------------------------------------------
//        int n = scn.nextInt();
//        int a = scn.nextInt();
//        int b = scn.nextInt();
//        int c = scn.nextInt();
//        System.out.println(maxPieces(n, a, b, c));
        //---------------------------------Todo:Subset of string----------------------------------------------------
//        String str = scn.nextLine();
//        subSet(str);
//        System.out.println("Using recursion tree");
//        subSetOptimise(str,"",0);
        //---------------------------------Todo:Tower of Hanoi----------------------------------------------------
//        int n = scn.nextInt();
//        char source = scn.next().charAt(0);
//        char intermediate = scn.next().charAt(0);
//        char destination = scn.next().charAt(0);
//        TOH(n,source,intermediate,destination);
        //---------------------------------Todo:Joshes problem----------------------------------------------------
//        int n = scn.nextInt();
//        int k = scn.nextInt();
//        System.out.println(josProblem(n, k));
//        System.out.println("Optimise solution");
//        System.out.println(josOptimise(n,k));
        //---------------------------------Todo:SubSet Sum problem----------------------------------------------------
//        System.out.println("Enter the size of array");
//        int n = scn.nextInt();
//        System.out.println("Enter the sum");
//        int sum = scn.nextInt();
//        int arr[] = new int[n];
//        System.out.println("Enter the elements");
//        for (int i = 0; i < n; i++) {
//            arr[i] = scn.nextInt();
//        }
//        int sum = 4;
//        int arr[] = {1, 2, 3};
//        System.out.println(subSetSum(arr, sum));
        //---------------------------------Todo:print all the permutation of string-------------------------------------
//        String str = scn.nextLine();
//        permutateString(str, 0);
//        String subString = "";
//        permutateString2(str, subString);
        //------------------------------------Todo:Binary Search ----------------------------------------------------------
//        int arr[] = {1, 2, 3, 4, 5};
//        System.out.println("Enter the element ot find");
//        int find = scn.nextInt();
//        System.out.println(binarySearch(arr, 0, arr.length - 1, find));
        //------------------------------------Todo:Repeated sum---------------------------------------------------------
        int num =9999;
        System.out.println(repeatedSumOfDigits(num));
    }
}
