import java.util.*;

public class Prioritize {
    int[] Priority(int[] arr) {
        LinkedHashSet<Integer> a = new LinkedHashSet<>();//For Prime Numbers
        LinkedHashSet<Integer> b = new LinkedHashSet<>();//For Powers of 2
        LinkedHashSet<Integer> c = new LinkedHashSet<>();//For others
        int[] newArray = new int[arr.length];
        for (int j : arr) {
            if (isPrime(j)) {
                a.add(j);
            } else if (isPowerOfTwo(j)) {
                b.add(j);
            } else {
                c.add(j);
            }
        }
        int z = 0;
        for (Integer s : a) {  // Adding first priority id to the array
            newArray[z++] = s;
        }
        for (Integer s : b) { // Adding second priority id to the array
            newArray[z++] = s;
        }
        for (Integer s : c) { // Adding least priority id to the array
            newArray[z++] = s;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return newArray;
    }

    boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int k = (int)Math.sqrt(n); //Optimized Version !!!!
        for (int i = 2; i < k; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
