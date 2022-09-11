//寻找在n个元素当中的最小的k个元素
import java.util.Collections;
import java.util.PriorityQueue;
public class topK {

    public int[] getLeastNumbers(int[] arr, int k) {

        //使用java库中的优先队列实现
        //变成最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<k;i++)
            pq.add(arr[i]);
        for(int i = k; i<arr.length;i++)
            if(!pq.isEmpty()&&arr[i] <pq.peek()){
                //出队出的是堆中的最大值
                pq.remove();
                pq.add(arr[i]);
            }

        int [] res= new int[k];
        for(int i = 0;i<k;i++)
            res[i]=pq.remove();
        return res;

        //自己设置的堆和优先队列实现
        /*PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i = 0;i<k;i++)
            pq.enqueue(arr[i]);

        for(int i = k; i<arr.length;i++)
            if(!pq.isEmpty()&&arr[i] <pq.getFront()){
                //出队出的是堆中的最大值
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        int [] res= new int[k];
            for(int i = 0;i<k;i++)
                res[i]=pq.dequeue();
        return res;
    }

         */
    }
}
