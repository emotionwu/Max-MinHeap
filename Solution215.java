import java.util.PriorityQueue;
//库中的堆默认为最小堆
//寻找第k大元素
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        //系统自带的优先队列实现
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        for (int i = k; i < nums.length; i++)
            if(!pq.isEmpty() && nums[i]> pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        return pq.peek();
*/

            //使用自己设置的最小堆实现
        MinHeap<Integer> pq = new MinHeap<>();
        for(int i = 0; i < k; i ++)
            pq.add(nums[i]);

        for(int i = k; i < nums.length; i ++)
            if(!pq.isEmpty() && nums[i] > pq.findMin())
                // 我们可以直接使用我们封装 Heap 类中的 replace
                pq.replace(nums[i]);

        return pq.findMin();
    }
}