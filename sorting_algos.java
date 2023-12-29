import java.util.*;

public class sorting_algos {

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void printARRAY(Integer arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] swap(int []arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return arr;
    }

    public static void bubble(int arr[]){                         //DESCENDING ORDER
        
        for(int i=0; i<arr.length-1; i++){
            int swaps=0;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] < arr[j+1]){
                    swap(arr, j, j+1);

                    swaps++;
                }
            }
                if(swaps == 0)
                break;
        }
    }

    public static void Selection(int arr[]){                        //ASCENDING ORDER

        for(int i=0; i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1; j<arr.length; j++){                       
                if(arr[j] < arr[minPos])
                minPos = j;
        }
        swap(arr, minPos, i);
        }

    }


    public static void Insertion(int arr[]){                       //DESCENDING ORDER
        for(int i=1; i <arr.length; i++){
            int curr = arr[i];
            int prev = i-1;

            while(prev >=0 && arr[prev] < curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }


    public static void Counting(int arr[]){                     //ASCENDING ORDER
        int lrgst = Integer.MIN_VALUE;
        for(int i=0; i <arr.length; i++){
            lrgst = Math.max(lrgst, arr[i]);
        }

        int count[] = new int [lrgst+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i = 0; i < arr.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

//     static void minMaxSelectionSort(int[] arr, int n)
//     {
//     for (int i = 0, j = n - 1; i < j; i++, j--)
//     {
//         int min = arr[i], max = arr[i];
//         int min_i = i, max_i = i;
//         for (int k = i; k <= j; k++)
//         {
//             if (arr[k] > max)
//             {
//                 max = arr[k];
//                 max_i = k;
//             }
             
//             else if (arr[k] < min)
//             {
//                 min = arr[k];
//                 min_i = k;
//             }
//         }
 
//         // shifting the min.
//         swap(arr, i, min_i);
 
//         // Shifting the max. The equal condition
//         // happens if we shifted the max to arr[min_i]
//         // in the previous swap.
//         if (arr[min_i] == max)
//             swap(arr, j, min_i);
//         else
//             swap(arr, j, max_i);
//     }
// }


    public static void main(String[] args){
        int array[] = {25, 2 , 6, -9, 46, 90};
        bubble(array);
        printArray(array);

        Selection(array);
        printArray(array);

        Insertion(array);
        printArray(array);

        Integer arr[] = {25, 2 , 6, -9, 46, 90};
        Arrays.sort(arr);                                                               //ASCENDING ORDER by default
        printARRAY(arr);
        Arrays.sort(arr, 0, 2, Collections.reverseOrder());
        printARRAY(arr);

        int arr1[] = {1, 4, 7, 12, 5, 4, 3, 1, 7, 1, 4, 5, 3};
        Counting(arr1);
        printArray(arr1);

    }
    
}