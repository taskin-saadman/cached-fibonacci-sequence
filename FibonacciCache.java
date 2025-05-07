import java.util.*;
public class FibonacciCache {
    private Map<Integer, int[]> cache;
    public FibonacciCache() { // constructor
    cache = new HashMap<Integer, int[]>(); //hashmap to store the Fibonacci sequence
    //key = n, value = Fibonacci sequence of n (the array of Fibonacci numbers)
    }
    public int[] generateSequence(int n) { //recursive method to generate Fibonacci sequence
    if(cache.containsKey(n)) {
    return cache.get(n); //return the cached sequence if it already exists
    //so we dont need to calculate it again (memory taken, but faster)
    } else {
        //else do normal recursion to calculate the Fibonacci sequence
    //and store it in the cache
    if(n == 0) {
    return new int[] {0};
    } else if(n == 1) {
    return new int[] {0, 1};
    } else {
    int[] f1 = generateSequence(n-1);
    int[] f2 = generateSequence(n-2);
    int[] newF = new int[f1.length+1];
    for(int i = 0; i < f1.length; i++)
    newF[i] = f1[i];
    newF[newF.length-1] = f1[f1.length-1] + f1[f1.length-2];
    cache.put(n, newF); //store the new sequence in the cache
    return newF;
    }
    }
    }

    public static void main(String[] args) {
    FibonacciCache fib = new FibonacciCache(); //create a new FibonacciCache object
        System.out.println("Fibonacci sequence of 5: " + Arrays.toString(fib.generateSequence(5)));
    }
   }