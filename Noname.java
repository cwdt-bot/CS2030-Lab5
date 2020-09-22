/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Noname {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), target = sc.nextInt();
        int[] arr = new int[num];
        for (int n = 0; n < num; n++) arr[n] = sc.nextInt();
        Arrays.sort(arr);
        int head = 0, tail = num-1;
        long counter = 0;
        while (head < tail) {
            while (arr[head] + arr[tail] > target){
                if (head >= tail) break;
                else tail--;
            }
            counter += tail - head;
            head++;
        }
        System.out.println(counter);
        sc.close();
    }

    public static void main(String args[]) {
        Noname runner = new Noname();
        runner.run();
    }
}
