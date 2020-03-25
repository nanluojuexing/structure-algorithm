package structure.heap;


import java.util.Arrays;

/**
 * 完全二叉树：
 *  不一定是满的二叉树，缺失的部分一定是在左叉树的部分。按层放置
 *  1。叶子结点只能出现在最下一层（满二叉树继承而来）
 *  2。最下层叶子结点一定集中在左 部连续位置。
 *  3。倒数第二层，如有叶子节点，一定出现在右部连续位置。
 *  4。同样结点树的二叉树，完全二叉树的深度最小（满二叉树也是对的）
 *
 *  二叉堆
 *  堆中某个节点的值总是不大于其父亲节点的值
 *
 *  最大堆 （根节点元素最大）
 */
public class MaxHeap {

    /**
     * 数组。从下标为1开始存储元素
     */
    private int[] queue;

    /**
     * 堆中可存的最大数据个数
     */
    private int n;

    /**
     * 堆中已村的数据个数
     */
    private int count;

    public MaxHeap(int capacity) {
        this.n = capacity;
        count =0;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(int data){

        if(count>=n){
            throw  new IllegalArgumentException("heap not space!");
        }
        // 数组下标位置要加1
        count++;
        // 存储数组，添加到未尾
        queue[count] = data;
        int i = count;
        // 进行位置交换
        while(i/2>0 && queue[i] > queue[i/2]){
            swap(queue,i,i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素
     */
    public void removeMax() {
        // 堆中没有数据
        if (count == 0)
            throw new IllegalArgumentException("element is empty!");
        // 将末尾元素移到堆顶的位置
        queue[1] = queue[count];
        // 元素减去1
        --count;
        // 元素下沉
        heapify(queue, count, 1);
    }

    /**
     * 堆化，自顶向下
     * @param a 存储元素的数组
     * @param n 堆中的元素数量
     * @param i 堆顶的索引位置
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {

            int maxPos = i;
            // 对比堆顶的元素何其左子树的节点的大小
            if (i*2 <= n && a[i] < a[i*2])
                maxPos = i*2;

            if (i*2+1 <= n && a[maxPos] < a[i*2+1])
                maxPos = i*2+1;

            if (maxPos == i)
                break;

            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 交换元素
     * @param queue
     * @param i
     * @param j
     */
    private void swap(int[] queue,int i, int j){

        if(i < 0 || i >= n || j < 0 || j >= n)
            throw new IllegalArgumentException("Index is illegal.");

        int t = queue[i];
        queue[i] = queue[j];
        queue[j] = t;
    }


    /**
     * 数组的上浮调整 最小堆
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array){

        int childIndex = array.length-1;
        // 获得父节点索引位置
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        // 进行元素交换，
        while (childIndex>0 && temp < array[parentIndex]){
            // 这里不需要真正的交换，赋值就行
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            // 获得新的父亲节点索引
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 元素的下沉 最小堆
     * @param arr
     * @param parentIndex 要下沉的父亲节点
     * @param length 堆的大小
     */
    public static void downAdjust(int[] arr,int parentIndex,int length){

        // temp保存父节点的值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex+1;
        while(childIndex < length){
            // 如果右孩子节点，切有孩子节点小于左孩子节点，则定位到有孩子节点
            if(childIndex+1 < length && arr[childIndex+1] < arr[childIndex]){
                childIndex++;
            }
            // 如果父节点大于任何一个节点的值，直接结束
            if(arr[childIndex] >= temp){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex+1;
        }
        arr[parentIndex] = temp;
    }

    /**
     * 构建最小堆
     * @param array
     */
    public static void buildHeap(int[] array){
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array,i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);

        System.out.println(Arrays.toString(array));

        int[] arr = {7,1,3,10,5,2,8,9,6};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
