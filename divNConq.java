public class divNConq {

    public static void printArr(int arr[], int i){
        // while(i < arr.length)
        //     System.out.print(arr[i++]+",\t");
        for(int k : arr){
            System.out.print(k+",\t");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);            //sort left part
        mergeSort(arr, mid+1, ei);          //sort right part

        merger(arr, si, mid, ei);
    }

    public static void merger(int[] arr, int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid +1, k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] > arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //leftovers
        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= mid)
            temp[k++] = arr[j++];
        //write in original array
        for(i=si, k=0; k<temp.length; k++ ,i++){
            arr[i] = temp[k];
            // System.out.print(arr[i]+",\t");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si >= ei)
            return;
        
        int pivot = partition(arr, si, ei);
        quickSort(arr, 0, pivot-1);
        quickSort(arr, pivot+1, ei);
    }

    public static int partition(int[] arr, int si, int ei){
        int i = si-1;
        for(int j = si; j<ei; ++j){
            if(arr[j] < arr[ei]){
                i++;
                arr[i] = (arr[i]+arr[j]) - (arr[j] = arr[i]);
            }
        }
        i++;
        arr[i] = (arr[i]+arr[ei]) - (arr[ei] = arr[i]);
        return i;
    }

    public static void rotateArray(int[] arr, int pivot){
        reverse(arr, 0, pivot-1);
        reverse(arr, pivot, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
    public static void reverse(int arr[], int si, int ei){
        while(si < ei){
            arr[si] = arr[si] + arr[ei] - (arr[ei] = arr[si]);
            si++;
            ei--;
        }
    }

    public static int RotSearch(int[] arr, int key, int si, int ei){
        if(si > ei)
            return -1;

        int mid = si + (ei-si)/2;
        if(arr[mid] == key)
            return mid;

        if(arr[mid] >= arr[si] ){                                      //mid is on Line1
            if(key >= arr[si] && key <= arr[mid])                      //key is on the left of mid in L1
                return RotSearch(arr, key, si, --mid);
            else
                return RotSearch(arr, key, ++mid, ei);                 //key is on the right of mid in L1
        }
        else{                                                          //mid is on Line2
            if(key <= arr[ei] && key >= arr[mid])
                return RotSearch(arr, key, ++mid, ei);                 //key is on the right of mid in L2
            else
                return RotSearch(arr, key, si, --mid);                 //key is on the left of mid in L2
        }
    }
    public static void main(String[] args){
        int arr[] = {2 ,12, 24, 45, 56, 67, 78, 89, 90, 0};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr, 0);
        quickSort(arr, 0, arr.length-1);
        printArr(arr, 0);
        rotateArray(arr, 4);
        printArr(arr, 0);
        System.out.println(RotSearch(arr, 24, 0, arr.length-1));        
    }
}
