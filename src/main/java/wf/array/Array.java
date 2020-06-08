package wf.array;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/8 11:14
 */
public class Array<E> {

    private E[] data;
    private int size;

    //根据传入数组长度确定数组
    public Array(int capacity) {
//        this.data = new int[capacity];
        data = (E[])new Object[capacity];//使用泛型声明数组使用该方法
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

    /**
     * 添加元素
     */

    //头插法
    public void addFirst(E e){
        add(0,e);
    }

    //向数组末尾添加一个元素
    public void addLast(E e){
//        if (size == data.length){
//            throw new IllegalArgumentException("数组条件失败，数组已满");
//        }
//        data[size] = e;
//        e ++;
        //在add方法写完后就可重写该方法
        add(size,e);
    }

    //向指定位置添加一个元素
    public void add(int index,E e){
        if (index <0 || index > size)
            throw new IllegalArgumentException("给定索引违法");
        if (size == data.length)
            resize(data.length *2);


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取元素
     */
    public E get(int index){
        if (index <0 || index > size)
            throw new IllegalArgumentException("给定索引违法");
        return data[index];
    }

    public void set(int index,E e){
        if (index <0 || index > size)
            throw new IllegalArgumentException("给定索引违法");
        data[index] = e;
    }

    /**
     * 查询
     */
    //判断元素是否在数组中
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //获取对应元素的索引，如果不存在返回 -1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除
     */
    //删除元素,并且返回待删除元素
    public E remove(int index){
        if (index <0 || index > size)
            throw new IllegalArgumentException("给定索引违法");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size] = null;
        size --;

        //如果数组中的值处于临界值状态，不停的增加删除数组元素，会加大复杂度，此时采用Lazy的方法
//        if (size < data.length/2){
//            resize(data.length/2);
//        }
        if (size < data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }

    //删除头元素
    public E removeFrist(){
        return remove(0);
    }

    //删除尾元素
    public E removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int i = find(e);
        if (i != -1){
            remove(i);
        }
    }


    private void resize(int newCapacity){
        E[] newdata = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

    @Override
    public String toString(){

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
