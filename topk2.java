//寻找在n个元素当中的最大的k个元素
public class topk2 {
    public int[] getLastNumbers(int[] arr, int k){
        PriorityQueue2<Integer> pq= new PriorityQueue2<>();
        for(int i = 0;i<k;i++)
            pq.enqueue(arr[i]);

        for(int i = k; i<arr.length;i++)
            if(!pq.isEmpty()&&arr[i] <pq.getFront()){
                //出队出的是堆中的最小值
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        int [] res= new int[k];
        for(int i = 0;i<k;i++)
            res[i]=pq.dequeue();
        return res;
    }
    public static void main(String []args){
        int arr[] ={1,3,5,7,4};
        int k =2;
        topk2 top = new topk2();
        top.getLastNumbers(arr,k);
            System.out.println();

    }
}
