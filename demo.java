// import java.util.*;

import java.util.Scanner;

public class demo{
    // public static void main(String[] args){
    //     Scanner aj = new Scanner (System.in);
    //     System.out.println("Enter the length of array:");                       //assumption: the array entered is sorted
    //     int l = aj.nextInt();
    //     int ar[]=new int[l];

    //     System.out.println("Enter the target:");
    //     int t = aj.nextInt();

    //     System.out.println("Enter the array:"); int i=0;
    //     while(i < l){
    //         ar[i] = aj.nextInt();
    //         i++;
    //     }

    //     int b = 0; int c = l-1;
    //     while(b < c){
    //         if(ar[b] + ar[c] == t){
    //             System.out.println("Elements found at indices:"+ b +"\t"+ c);
    //             break;
    //         }
    //         else if ((ar[b] + ar[c]) > t)     c--;
    //         else    b++;
    //     }

    public void moveZeroes(int[] nums) {
        // Initialize a variable to keep track of the index where non-zero elements should be placed
        int nonZeroIndex = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, swap it with the element at the nonZeroIndex
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        // Solution solution = new Solution();
        // demo.moveZeroes(nums);

        // Print the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
    }
}
