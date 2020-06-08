package wf.array;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/8 11:06
 */
public class Main {

    public static void main(String[] args) {
//        ArrayList
        Array array = new Array();

        for (int i = 0 ; i < 6 ; i ++){
            array.addLast(i + 1);
        }
        System.out.println(array);

        array.removeFrist();
        System.out.println(array);

        array.removeFrist();
        System.out.println(array);
    }
}
