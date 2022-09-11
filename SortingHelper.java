public class SortingHelper {
    private SortingHelper(){}
    public static<E extends Comparable<E>> boolean isSorted(E[]arr){
        for(int i=1;i<arr.length;i++)
            if(arr[i-1].compareTo(arr[i])>0)
                return false;
        return true;
    }
    public static<E extends Comparable<E>>  void sortTest(String sortname,E[]arr){
        long starTime=System.nanoTime();
      if(sortname.equals("HeapSort"))
            HeapSort.sort(arr);
        else if(sortname.equals("HeapSort2"))
            HeapSort.sort2(arr);
        long endTime=System.nanoTime();
        double time =(endTime-starTime)/1000000000.0;
        //判断排序是否正确
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname+" failed");
        System.out.println(String.format("%s, n=%d:%f s",sortname,arr.length,time));
    }

}
