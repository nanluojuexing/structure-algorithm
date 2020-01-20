package structure;

/**
 * @Author: mianba
 * @Date: 2019-08-02 17:54
 * @Description: 一个bite位来标记某个元素，数组下标就是该元素
 */
public class BitMap {

    public static void main(String[] args) {
        // 0110 0100
        int n =100;
        BitMap bitMap = new BitMap();
        bitMap.create(n);
    }

    /**
     * 创建bitmap数组
     * @param n
     * @return
     */
    public byte[] create (int n){

        // 构建数组 确认数组的长度
        byte[] bits= new byte[getIndex(n)+1];
        for (int i = 0; i < n; i++) {
            add(bits,i);
        }

        clear(bits,80);
        System.out.println(contains(bits,80));

        int index =1;
        for (byte bit : bits) {
            System.out.println("---------"+ index++ +"--------");
            showByte(bit);
        }

        return bits;
    }

    /**
    * @Description: 判断指定的数是否存在
    * @Param:
    * @return:
    * @Date: 2019-08-19
    */
    public boolean contains(byte[] bites ,int num){
        return (bites[getIndex(num)] & 1 << getPosition(num)) != 0;
    }
    /**
     *
     * @param bites
     * @param num
     */
    public void add(byte[] bites,int num){
        bites[getIndex(num)] |= 1 << getPosition(num);
    }
    /**
     *  num/8 获得 byte[] 的index
     * @param num
     * @return
     */
    public int getIndex(int num){
        return num >> 3;
    }

    /**
     *
     * @param num
     * @return
     */
    public int getPosition(int num){
        // num % 8
        return num & 0x07;
    }

    /**
     * 重置某一数字对应在bitmap中的值<br/>
     * 对1进行左移，然后取反，最后与byte[index]作与操作。
     * @param bits
     * @param num
     */
    public void clear(byte[] bits, int num){
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }

    /**
     * 打印byte类型的变量<br/>
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */

    public void showByte(byte b){
        byte[] array = new byte[8];
        for(int i = 7; i >= 0; i--){
            array[i] = (byte)(b & 1);
            b = (byte)(b >> 1);
        }

        for (byte b1 : array) {
            System.out.print(b1);
            System.out.print(" ");
        }

        System.out.println();
    }

}

