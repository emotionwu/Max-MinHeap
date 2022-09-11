
//最大堆
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    //将任意数组整理成堆的形状
    public MaxHeap(E[]arr){

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
        //最小值
        shifUp(data.getSize()-1);
    }

    private void shifUp(int K) {
        while (K > 0 && data.get(parent(K)).compareTo(data.get(K)) < 0) {
            data.swap(K, parent(K));
            K = parent(K);
        }
    }
        //看堆中最大元素
        public E findMax(){
            if(data.getSize() == 0)
                throw new IllegalArgumentException("Can not findMax when heap is empty.");
            return data.get(0);
        }

        //取出堆中最大元素
        public E extractMax(){
            E ret = findMax();

            data.swap(0,data.getSize()-1);
            data.removeLast();
            siftDown(0);
        return ret;
    }

    private void siftDown(int K){

        while(leftChild(K) < data.getSize()){
            int j = leftChild(K);
            if(j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))>0)
                j=rightChild(K);
            //得到了左右孩子中的最大值
            // data[j] 是leftChild 和rightChild中的最大值
            if(data. get(K).compareTo(data.get(j))>=0)
                break;
            data.swap(K,j);
            K=j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e
    public E replace (E e){

        E ret= findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }


}
