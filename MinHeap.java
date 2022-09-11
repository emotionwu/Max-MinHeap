//最小堆
import java.util.Random;
public class MinHeap<E extends Comparable<E>> {

        private Array<E> data;
        public MinHeap(int capacity){
            data = new Array<>(capacity);
        }

        public MinHeap(){
            data = new Array<>();
        }

        //将任意数组整理成堆的形状
        public MinHeap(E[]arr){

            data = new Array<>(arr);
            //从最后一个非叶子节点开始下沉
            for(int i=parent(arr.length-1);i>=0;i--)
                siftDown(i);
        }
        //返回堆中的元素个数
        public int size(){
            return data.getSize();
        }

        //返回一个布尔值，表示堆中是否为空
        public boolean isEmpty(){
            return data.isEmpty();
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
        private int parent(int index){
            if(index == 0)
                throw new IllegalArgumentException("index-0 doesn't have parent.");
            return (index-1)/2;
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index){
            return index*2 +1;
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int rightChild(int index){
            return index*2 +2;
        }

        //向堆中添加元素
        public void add(E e){
            data.addLast(e);
            //将最后一个位置的元素调整
            shifUp(data.getSize()-1);
        }

        private void shifUp(int K) {
            while (K > 0 && data.get(parent(K)).compareTo(data.get(K)) >0) {
                data.swap(K, parent(K));
                K = parent(K);
            }
        }
        //看堆中最小元素
        public E findMin(){
            if(data.getSize() == 0)
                throw new IllegalArgumentException("Can not findMax when heap is empty.");
            return data.get(0);
        }

        //取出堆中最小元素
        public E extractMin(){
            E ret = findMin();

            data.swap(0,data.getSize()-1);
            data.removeLast();
            siftDown(0);
            return ret;
        }

        private void siftDown(int K){

            while(leftChild(K) <data.getSize()){
                int j = leftChild(K);
                if(j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))<0)
                    j=rightChild(K);
                //得到了左右孩子中的最小值
                // data[j] 是leftChild 和rightChild中的最小值
                if(data. get(K).compareTo(data.get(j))<=0)
                    break;
                data.swap(K,j);
                K=j;
            }
        }

        //取出堆中的最小元素，并且替换成元素e
        public E replace (E e){

            E ret= findMin();
            data.set(0,e);
            siftDown(0);
            return ret;
        }

    public static void main(String[] args) {

        int n = 1000000;

        MinHeap<Integer> minHeap = new MinHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++)
            minHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)
            arr[i] = minHeap.extractMin();

        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] > arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MinHeap completed.");
    }
}



