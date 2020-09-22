/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Inversion {
    //tracks the number of swaps between consecutive elements
    private long counter = 0;

    private void mergesort(int[] a, int i, int j) {
        if (i < j) {
            int mid = (i + j)/2;
            mergesort(a, i, mid);
            mergesort(a, mid+1, j);
            merge(a, i, mid, j);
        }
    }

    //overloaded form of mergesort for easy use
    private void mergesort(int[] a) {
        this.mergesort(a, 0, a.length-1);
    }

    //merging algo that increments COUNTER each time 
    //element is added from the right side 
    private void merge(int[] a, int i, int mid, int j) {
        int[] curr = new int[j-i+1];
        int left = i;
        int right = mid + 1;
        int ele = 0;
        while (left <= mid && right <= j) {
            if(a[left] <= a[right]) {
                curr[ele++] = a[left++];
            } else {
                curr[ele++] = a[right++];
                //the number of swaps that need to be done is 
                //determined by the number of elements left on the
                //left side, which we can track via mid and left. 
                this.counter += mid-left+1;
            }
        }
        while(left <= mid) curr[ele++] = a[left++];
        while(right <= j) curr[ele++] = a[right++];
        for (int k = 0; k < curr.length;k++) a[i+k] = curr[k];
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] input = new int[num];
        for (int n = 0; n < num; n++) {
            input[n] = sc.nextInt();
        }
        this.mergesort(input);
        System.out.println(this.counter);
        this.counter = 0; //reset the counter for future use
        sc.close();
    }

    public static void main(String args[]) {
        Inversion runner = new Inversion();
        runner.run();
    }
}
