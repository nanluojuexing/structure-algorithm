package structure.array;

import java.util.Arrays;

/**
 * @Author: mianba
 * @Date: 2019-07-29 11:17
 * @Description: 简单动态数组
 */
public class Array<E> {

    /**
     * 定一个泛型数组接受元素
     */
    private E[] data;
    /**
     * 数组中的元素个数
     */
    private int size;

    /**
     * 初始化容量为10的空数组
     */
    public Array() {
        this(10);
    }
    /**
     * 初始化指定容量和元素的数组 有参构造
     * @param capacity
     */
    public Array(int capacity) {
        this.data = (E[])new Object[capacity];
        this.size = size;
    }

    /**
     * 获得数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 指定位置增加元素
     * @param index
     * @param e
     */
    public void add(int index ,E e){
        // 校验数组索引位置
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add failed,require index>=0 or index <= size");
        }
        // 盘算是否需要扩容,这里扩容的化翻倍
        if(size == data.length){
            resize(2*data.length);
        }
        // 移动数组元素，index后元素后移一位
        for (int i = size-1; i >=index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        //元素个数+1
        size++;
    }

    /**
     * 扩容
     * @param newCapacity
     */
    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        // 复制数组
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        // 赋值
        data=newData;
    }

    /**
     * 设置指定位置的元素为指定的值
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("set failed,require index>=0 or index <= size");
        }
        data[index] = e;
    }

    /**
     *  获得指定索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get failed,require index>=0 or index <= size");
        }
        return data[index];
    }

    /**
     * 获得指定元素的索引 找到返回索引位置，找不到返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < data.length; i++) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断是否包含指定的元素 存在返回true ,不存在返回false
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < data.length; i++) {
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("remove failed,require index>=0 or index <= size");
        }
        // 获得要删除的元素
        E rem = data[index];
        //移动后面的数组位置
        for (int i = index+1; i < size; i++) {
            data[i-1]= data[i];
        }
        // 元素个数减1
        size --;
        // 释放内存空间
        data[size] = null;
        // 判断数组是否需要缩容
        if(size == data.length/2){
            resize(data.length/2);
        }
        return rem;
    }
 
    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        // 获得元素的索引位置
        int i = find(e);
        // 找到元素的直接移除
        if(i>0){
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
