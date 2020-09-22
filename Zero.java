/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Zero {

    //precond: all inputs are integers
    //postcond: returns the number of continuous sub arrays that equal 0 
    private void run() {
        Scanner sc = new Scanner(System.in);
        int numIn = sc.nextInt();
        int[] sums = new int[numIn];

        //create a prefix sum for the inputs
        sums[0] = sc.nextInt();
        for (int n = 1; n < numIn; n++) {
            sums[n] = sums[n-1] + sc.nextInt();
        }
        //to ensure all the same sums are grouped together
        //so we dont have to search through the whole array to find
        //duplicates 
        Arrays.sort(sums);
        long count = 0;
        int same = 1;
        for (int x = 0; x < numIn; x++) {
            //every subarray with a sum of 0 should be counted
            if (sums[x] == 0) count++;
            //ignore the first element of the array since array[-1] does not exist
            if (x == 0) continue;
            //since it is sorted, all the occurences of the same prefix sum will
            //cluster together, from there, it is the same as n choose 2 number of 
            //subarrays, which is the same as 0 + 1 + ... + n
            else if (sums[x] == sums[x-1]) {
               count += same++;
            } else {
                same = 1;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static void main(String args[]) {
        Zero runner = new Zero();
        runner.run();
    }
}
