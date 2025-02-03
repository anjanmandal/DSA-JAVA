import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr={7,5,3,1,2};
        selectionSort(arr.length-1, 0, arr,0);
        System.out.println(Arrays.toString(arr));


    }
    static void bubbleShort(int row, int col,int [] arr ){
        if(row==0){
            return;
        }
        if(col<row){
            if(arr[col]>arr[col+1]){
                int temp=arr[col];
                arr[col]=arr[col+1];
                arr[col+1]=temp;
            }
            bubbleShort(row, col+1, arr);
        }else{
            bubbleShort(row-1, 0, arr);
            
        }

    }
    static void selectionSort(int row,int col,int[] arr,int maxIndex){
        if(row==0){
            return;
        }
        if(col<=row){
            if(arr[col]>arr[maxIndex]){
                maxIndex=col;
            }
            selectionSort(row, col+1, arr, maxIndex);
        }else{
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[row];
            arr[row]=temp;
            selectionSort(row-1, 0, arr, 0);
        }
    }
    
}
