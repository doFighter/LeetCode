package day01;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private class Node{
        private int key;
        private int value;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }
    }

    private LinkedList[] hashMap;
    private static final int BASE = 769;
    public MyHashMap(){
        hashMap = new LinkedList[BASE];
        for (int i=0;i < BASE;i++){
            hashMap[i] = new LinkedList<Node>();
        }
    }
    public void put(int key,int value){
        int index = key % BASE;
        Iterator<Node> iterator = hashMap[index].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key){
                node.setValue(value);
                return;
            }
        }
        hashMap[index].offerLast(new Node(key, value));
    }
    public int get(int key){
        int index = key % BASE;
        Iterator<Node> iterator = hashMap[index].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (node.getKey() == key){
                return node.getValue();
            }
        }
        return -1;
    }
    public void remove(int key){
        int index = key % BASE;
        Iterator<Node> iterator = hashMap[index].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (node.getKey() == key){
                iterator.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}
