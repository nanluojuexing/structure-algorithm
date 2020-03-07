package structure.stack;

/**
 * 基于数组实现的 顺序栈，且容量固定
 */
public class ArrayStackSelf {

    /**
     * 定义数组
     */
    private Object[] items;

    /**
     * 栈的容量
     */
    private int capacity;

    /**
     * 元素个数
     */
    public int size;

    public ArrayStackSelf(int capacity){
        items = new Object[capacity];
        this.capacity = capacity;
        size =0;
    }

    /**
     * 入栈操作
     * @param object
     * @return
     */
    public boolean push(Object object){

        if(capacity == size){
            return false;
        }
        // 从头部位置开始放置，从size位置开始
        items[size] = object;
        ++size;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){

        //栈为空
        if(size == 0){
            return null;
        }
        // 返回下标为count-1的数组元素，并且栈中元素个数count减一
        Object val = items[size-1];
        --size;
        return val;
    }
}
