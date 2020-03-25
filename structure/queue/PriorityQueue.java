package structure.queue;

import java.util.Arrays;

/**
 * 基于数组实现的 优先队列
 */
public class PriorityQueue {

    private int[] array;

    private int size;

    public PriorityQueue(){
        array = new int[32];
        size = 0;
    }

    /**
     * 入队操作
     * @param key
     */
    public void enQueue(int key){
        // 超出队列，需要扩容
        if(size>=array.length){
            resize();
        }
        // 元素添加在数组的最后一位
        array[size++]=key;
        // 元素上浮
        upAdjust();
    }

    /**
     * 出队操作
     */
    public int deQueue() throws Exception{
        // 超出队列，需要扩容
        if(size < 0 ){
            throw new Exception("the queue id empety!");
        }
        // 获取到栈顶的元素
        int head = array[0];
        // 最后一个元素移动到堆顶，将最后一个元素移到堆顶，是为了保证二叉树的平衡性
        array[0] = array[--size];
        // 下浮操作
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust(){
        // 记录子节点的位置
        int childIndex = size-1;
        // 获取父节点的位置
        int parentIndex= childIndex/2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        // 和父节点进行大小比对，如果大于父节点，则进行交换
        while(childIndex>0 && temp > array[parentIndex]){
            // 不需要真正的交换，单项赋值就行
            // 子节点的值更换为父节点的值
            array[childIndex] = array[parentIndex];
            // 交换索引位置
            childIndex=parentIndex;
            // 获取交换后未知的父节点
            parentIndex=parentIndex/2 ;
        }
        // 获取最后的索引位置，将插入的节点放在索引位置上
        array[childIndex]= temp;

    }

    /**
     * 下沉调整
     */
    private void downAdjust(){
        // temp保存父节点的值
        int parentIndex =0;
        // 获取堆顶的元素值
        int temp = array[parentIndex];
        // 这里拿到是左节点的索引位置
        int childIndex=1;
        while(childIndex < size){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]){
                childIndex++;
            }
            // 父节点大于任何一个孩子节点的值，则直接结束
            if(temp>=array[childIndex]){
                break;
            }
            // 交换元素
            array[parentIndex]= array[childIndex];
            parentIndex= childIndex;
            childIndex = 2* childIndex+1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 数组扩容
     */
    private void resize(){
        int newSize = this.size*2;
        this.array = Arrays.copyOf(this.array,newSize);
    }


    public static void main(String[] args) throws Exception{
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);

        System.out.println("出队元素："+priorityQueue.deQueue());
        System.out.println("出队元素："+priorityQueue.deQueue());
    }
}
