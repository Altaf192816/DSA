
import java.util.Arrays;
import java.util.Scanner;

import java.lang.Math;

public class Maths {
    public static long fact(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static long factRecursive(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factRecursive(num - 1);
    }

    public static int trailingZero(int num) {
        long factNum = fact(num);
        int countZero = 0;
        while (factNum != 0) {
            if ((factNum % 10) != 0) {
                break;
            }
            countZero++;
            factNum /= 10;
        }
        return countZero;
    }

    public static int trailingZeroOptimize(int num) {
        int zeroes = 0;
        for (int i = 5; i <= 100; i *= 5) {
            zeroes = zeroes + num / i;
        }
        return zeroes;
    }

    public static int getGcd(int a, int b) {
        int gcd = 0;
        for (int i = 2; (i <= a || i <= b); i++) {
            if ((a % i == 0) && (b % i == 0)) {
                gcd = i;

            }
        }
        return gcd;

    }

    public static int getGcd2(int a, int b) {
        int gcd = java.lang.Math.min(a, b);
        while (gcd > 0) {
            if (a % gcd == 0 && b % gcd == 0) {
                break;
            }
            gcd--;
        }
        return gcd;

    }

    public static int eulcideGcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int eulcideGcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return eulcideGcd2(b, a % b);
    }

    public static int lcm(int a, int b) {
        int maxNum = java.lang.Math.max(a, b);//a = 4 b=6 max =6
        while (maxNum < a * b) {//max =6 <= 24
            if (maxNum % a == 0 && maxNum % b == 0) {
                return maxNum;
            }
            maxNum++;
        }
        return maxNum;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeOptimise(int num) {
        if (num == 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void primeFactor(int num) {
        if (num <= 1) return;
        if (isPrimeOptimise(num)) {
            System.out.println(num);
            return;
        }
        int i = 2;
        while (num != 1) {
            if (num % i == 0 && isPrimeOptimise(i)) {
                System.out.print(i + "\t");
                num /= i;
                continue;
            }
            i++;
        }
    }

    public static void primeFactorOptimize(int num) {
        if (num <= 1) return;
        if (isPrimeOptimise(num)) {
            System.out.println(num);
            return;
        }
        while (num % 2 == 0) {
            System.out.println(2);
            num /= 2;
        }

        while (num % 3 == 0) {
            System.out.println(3);
            num /= 3;
        }

        for (int i = 5; i * i <= num; i += 6) {
            while (num % i == 0) {
                System.out.println(i);
                num /= i;
            }
            while (num % (i + 2) == 0) {
                System.out.println(i + 2);
                num /= (i + 2);
            }
        }
        if (num > 3) {
            System.out.println(num);
        }
    }

    public static void divisors(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) System.out.print(i + "\t");
        }
    }

    public static void divisorsOptimise(int num) {
        String sort = "";
        for (int i = 1; i * i <= num; i++) {

            int x = num % i;
            int y = num / i;
            if (x == 0) {
                System.out.print(i + "\t");
            }
            if (i != y && x == 0) {
                sort = y + "\t" + sort;
            }
        }
        System.out.println(sort);
    }

    public static void divisorsOptimise2(int num) {
        int i = 1;
        for (; i * i < num; i++) {
            if (num % i == 0) {
                System.out.print(i + "\t");
            }
        }
        for (; i > 0; i--) {
            if (num % i == 0) {
                System.out.print(num / i + "\t");
            }

        }

    }

    public static void primeNumber(int num) {
        for (int i = 2; i <= num; i++) {
            if (isPrimeOptimise(i)) System.out.print(i + "\t");//efficent method

//            boolean is = true;
//            for (int j = 2; j*j <= i ; j++) {
//                if(i%j==0) is=false;
//            }
//            if(is) System.out.print(i+"\t");

        }
    }

    public static void sieveOfEraosthenes(int num) {
        //[t,t,t,t,t,t,t,t,t,t]
        //[0,1,2,3,4,5,6,7,8,9]
        //after algorithm
        //[t,t,t,t,f,t,f,t,f,f]
        /*
        boolean arr[] = new boolean[num +1];
        Arrays.fill(arr,Boolean.TRUE);
        for (int i = 2; i*i <= num ; i++) {//i =2
            if(arr[i]){
//                for (int j = 2*i; j <= num ; j = j +i) {//j=4 to num and increase by 2 each time j = 4 +2 =6
                for (int j = i*i; j <= num ; j = j +i) {//below i^2 value already marked false by lower j
                    arr[j] = false;
                }
            }
        }
        for (int i = 2; i <= num ; i++) {
           if(arr[i]) System.out.print(i+"\t");
        }
*/
        //reduced code
        boolean arr[] = new boolean[num + 1];
        Arrays.fill(arr, Boolean.TRUE);
        for (int i = 2; i <= num; i++) {
            if (arr[i]) {
                System.out.print(i + "\t");
                for (int j = i * i; j <= num; j = j + i) {
                    arr[j] = false;
                }
            }
        }

    }

    public static int powerOptimise_Recursive(int x, int n) {
        //base case
        if (n == 1) return x;
        //recursive case
        if (n % 2 == 0) {
            return powerOptimise_Recursive(x, n / 2) * powerOptimise_Recursive(x, n / 2);
        } else {
            return powerOptimise_Recursive(x, n - 1) * x;
        }
    }

    public static int powerOptimise_Iterative(int x, int n) {
        int res = 1;
        while (n != 0) {
            //bit is 1
            if (n % 2 != 0) {
                res = res * x;
            }
            n /= 2;
            x = x * x;
        }
        return res;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int absoulteValue(int num) {
        if (num < 0) {
            return num * -1;
        }
        return num;
    }

    static double celciusToFahrenheit(int C) {
        return C * 1.8 + 32;
    }

    static int digits(double num) {
        return (int) Math.floor((Math.log10(num) + 1));
    }

    static int facDigits(int N) {
        //code here
        if (N == 0 || N == 1) return 1;
        double digit = 0;
        for (int i = 2; i <= N; i++) {
            digit += Math.log10(i);
        }
        return (int) (digit + 1);
    }

    static int nthTermGp(int a, int r, int n) {
        return a * (int) Math.pow(r, n - 1);
    }

    static void exactlt_3_Divisor(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (isPrimeOptimise(i)) {
                System.out.print(i * i + "\t");
            }
        }
    }

    static long sumModulo(long n1, long n2, long m) {
        return ((n1 % m) + (n2 % m)) % m;
    }

    static int modularInverse(int a, int m) {
        int b = -1;
        if (getGcd2(a, m) != 1) return b;
        for (int i = m - 1; i > 0; i--) {
            if ((a * i) % m == 1) {
                b = i;
            }
        }
        return b;
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int sub = prices[j] - prices[i];
                if (sub <= 0) {
                    break;
                }
                if (sub > max) {
                    max = sub;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //Todo :- Factorial---------------------------------------------------------------------------------
        /*
        int num = scn.nextInt();
        System.out.println(factRecursive(num));
         */
        //Todo :- Trailing zero in factorial----------------------------------------------------------------
//        int num = scn.nextInt();
//        System.out.println("Naive solution");
//        System.out.println(trailingZero(num));
//        System.out.println("Efiicent solution");
//        System.out.println(trailingZeroOptimize(num));

        //Todo :- Gcd---------------------------------------------------------------------------------------
//        int a = scn.nextInt();
//        int b = scn.nextInt();
//        System.out.println("Naive solution");
//        System.out.println("gcd is " + getGcd(a, b));
//        System.out.println("gcd is " + getGcd2(a, b));
//        System.out.println("Efiicent solution");
//        System.out.println("Euclidien algo GCD :-"+ eulcideGcd(a,b));
//        System.out.println("Optimise Euclidien algo GCD :-"+ eulcideGcd2(a,b));

        //Todo :- lCM---------------------------------------------------------------------------------
//        int a = scn.nextInt();
//        int b = scn.nextInt();
//        System.out.println(lcm(a, b));
//       System.out.println("Efiicent solution");
//        int lcmOptimise = (a*b)/eulcideGcd2(a,b);
//        System.out.println(lcmOptimise);
        //Todo :- Prime---------------------------------------------------------------------------------
//        int num = scn.nextInt();
//        System.out.println((isPrime(num) ? "prime number " : "Not a prime number"));
//        System.out.println("Efficent method");
//        System.out.println((isPrimeOptimise(num) ? "prime number " : "Not a prime number"));

        //Todo :- Primefactor---------------------------------------------------------------------------------
//        int num = scn.nextInt();
//        primeFactorOptimize(num);
        //Todo :- All divisor---------------------------------------------------------------------------------
//        int num = scn.nextInt();
//        divisors(num);
//        System.out.println();
//        System.out.println("Efficent solution");
//        divisorsOptimise2(num);
        //Todo :- Sieve of eratoshenes----------------------------------------------------------------------
//        int num = scn.nextInt();
//        primeNumber(num);
//        System.out.println();
//        System.out.println("Using sieve of eratoshenes");
//        sieveOfEraosthenes(num);

        //Todo :- Power---------------------------------------------------------------------------------
//        System.out.println("Enter the number");
//        int num = scn.nextInt();
//        System.out.println("Enter the power");
//        int power = scn.nextInt();
//        System.out.println(powerOptimise_Recursive(num, power));
//        System.out.println(powerOptimise_Iterative(num,power));
        //Todo :- Absolute value---------------------------------------------------------------------------------
//        int num  =scn.nextInt();
//        System.out.println(absoulteValue(num));
        //Todo :- celciusToFahrenheit---------------------------------------------------------------------------------
//        int num = scn.nextInt();
//        System.out.print(celciusToFahrenheit(num));
//        double num = (double) 9/5;
//        System.out.println(num);
        //Todo :- FactorialDigits---------------------------------------------------------------------------------

//        int num = scn.nextInt();
//        double factNum = fact(num);
//        System.out.println(digits(factNum));
//        System.out.println("Above code not work on large value of num");
//        System.out.println("Using optimise solution "+facDigits(num));

        //Todo :- Gp terms---------------------------------------------------------------------------------
//        System.out.println("Enter the first term");
//        int a = scn.nextInt();
//        System.out.println("Enter the ratio");
//        int r = scn.nextInt();
//        System.out.println("Enter the term to find");
//        int n = scn.nextInt();
//        System.out.println("Nth term is "+ nthTermGp(a,r,n));
        //Todo :Excatly 3 divisor---------------------------------------------------------------------------------
//        int num = scn.nextInt();
//        exactlt_3_Divisor(num);
        //Todo :Addition Under Modulo---------------------------------------------------------------------------------
//        long num1 = scn.nextLong();
//        long num2 = scn.nextLong();
//        long M = 1000000007;
//        System.out.println(sumModulo(num1,num2,M));
        //Todo :Modulo inverse------------------------------------------------------------------------------
//        System.out.println("Enter value of a ");
//        int a = scn.nextInt();
//        System.out.println("Enter value of m ");
//        int m = scn.nextInt();
//        System.out.println("Modulo inverse is " + modularInverse(a,m));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
