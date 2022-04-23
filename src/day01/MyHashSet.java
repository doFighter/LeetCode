package day01;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * MyHashSet版本一，在该版本中，容量固定，因此当集合保存的数据较少时，会极大地浪费空间
 */
/*
public class MyHashSet {
    boolean[] hash;
    public MyHashSet(){
        hash = new boolean[1000001];
    }
    public void add(int key){
        hash[key] = true;
    }
    public void remove(int key){
        hash[key] = false;
    }
    public boolean contains(int key){
        return hash[key];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));// 返回 True
        System.out.println(myHashSet.contains(3));// 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));// 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));// 返回 False，（已删除）
    }
}
*/

public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] hash;

    public MyHashSet(){
        hash = new LinkedList[BASE];
        for (int i = 0;i < BASE; i++){
            hash[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int index = key % BASE;
        Iterator<Integer> iterator = hash[index].iterator();
        while (iterator.hasNext()){
            if(iterator.next() == key){
                return;
            }
        }
        hash[index].offerLast(key);
    }

    public void remove(int key){
        int index = key % BASE;
        Iterator<Integer> iterator = hash[index].iterator();
        while (iterator.hasNext()){
            if (iterator.next() == key){
                iterator.remove();
                return;
            }
        }
    }

    public boolean contains(int key){
        int index = key % BASE;
        Iterator<Integer> iterator = hash[index].iterator();
        while (iterator.hasNext()){
            if (iterator.next() == key){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));// 返回 True
        System.out.println(myHashSet.contains(3));// 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));// 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));// 返回 False，（已删除）
    }
}

