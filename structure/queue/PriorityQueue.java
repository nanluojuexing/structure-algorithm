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
        // 最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust(){
        int childIndex = size-1;
        int parentIndex= childIndex/2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while(childIndex>0 && temp > array[parentIndex]){
            // b不需要真正的交换，单项赋值就行
            array[childIndex] = array[parentIndex];
            childIndex=parentIndex;
            parentIndex=parentIndex/2 ;
        }
        array[childIndex]= temp;

    }

    /**
     * 下沉调整
     */
    private void downAdjust(){
        // temp保存父节点的值
        int parentIndex =0;
        int temp = array[parentIndex];
        int childIndex=1;
        while(childIndex < size){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]){
                childIndex++;
            }

            if(temp>=array[childIndex]){
                break;
            }

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
