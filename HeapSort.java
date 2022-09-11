import java.util.Arrays;

public class HeapSort {

    private HeapSort(){}

    public static<E extends Comparable<E>> void sort(E[] data){
        MaxHeap<E> maxHeap =new MaxHeap<>();
        for(E e: data)
            maxHeap.add(e);

        for(int i = data.length-1;i>=0;i--)
           data[i]= maxHeap.extractMax();
    }

    public static<E extends Comparable<E>> void sort2(E[] data) {

        if(data.length<=1)
            return;

        for (int i = (data.length - 2)/2; i >= 0; i--)
            siftDown(data,i,data.length);

        for(int i =data.length-1;i>=0;i--){
            swap(data,0,i);
            //最大堆的数目每次减一
            siftDown(data,0,i);
        }
    }

    //对data[o,n)所形成的最大堆中，索引k的元素，执行siftDowm
    private static<E extends Comparable<E>> void siftDown(E[] data,int K,int n){

        while(2*K+1< n){
            int j = 2*K+1;
            if(j+1<n&& data[j+1].compareTo(data[j])>0)
                j++;
            //得到了左右孩子中的最大值
            // data[j] 是leftChild 和rightChild中的最大值
            if(data[K].compareTo(data[j])>=0)
                break;
            swap(data,K,j);
            K=j;
        }
    }

    public static <E extends Comparable<E>>void swap(E[] arr,int i, int j){

        E t = arr[i];
        arr[i]= arr[j];
        arr[j] = t;
    }

    public static void main (String [] args){
        int n = 1000000;

        Integer[] arr =ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("HeapSort",arr);
        SortingHelper.sortTest("HeapSort2",arr2);
    }
}
