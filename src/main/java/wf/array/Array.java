package wf.array;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/8 11:14
 */
public class Array {

    private int[] data;
    private int size;

    //根据传入数组长度确定数组
    public Array(int capacity) {
        this.data = new int[capacity];
        size = 0;
    }

    //设置默认无参构造，默认长度为10
    public Array() {
        this(10);
    }

    //获取数组中元素个数
    public int size(){
        return size;
    }

    //返回数组长度
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }
}
