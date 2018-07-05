package test;

import java.util.Iterator;

import alg.datastructrue.*;

/**
 * TestRAStack
 */
public class TestStack {

    public static void main(String[] args) {
        ResizingArrayStack<Integer> re = new ResizingArrayStack<Integer>();
        Iterator it = re.iterator();
        while(it.hasNext()){
            Integer var = (Integer)it.next();
            System.out.println(var);
        }
        System.out.println("=========");
        for (int i = 0; i < 10; i++) {
            re.push(i);
            System.out.println(re.size());
        }
    }
}