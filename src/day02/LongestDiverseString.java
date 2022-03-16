package day02;


import java.util.Arrays;

/**
 * 贪心法
 */
public class LongestDiverseString {
    private class Node{
        private int key;
        private char value;

        public Node(int key, char value){
            this.key = key;
            this.value = value;
        }
        public void setKey(int key){
            this.key = key;
        }
        public int getKey(){
            return this.key;
        }
        public char getValue(){
            return this.value;
        }
    }


    public String longestDiverseString(int a, int b, int c){
        Node[] kv = {new Node(a, 'a'), new Node(b, 'b'), new Node(c, 'c')};
        String result = "";
        while(true){
            Arrays.sort(kv, (k, v)->{
                return v.getKey() - k.getKey();
            });

            boolean isDown = false;
            for(Node node: kv){
                if (node.getKey() <= 0){
                    break;
                }
                if (result.length() >= 2 && result.charAt(result.length()-2) == node.getValue() && result.charAt(result.length()-1) == node.getValue()){
                    continue;
                }
                result = result + node.getValue();
                node.setKey(node.getKey() - 1);
                isDown = true;
                break;
            }

            if(!isDown){
                return result;
            }
        }
    }

    public static void main(String[] args) {
        LongestDiverseString lds = new LongestDiverseString();
        String res = lds.longestDiverseString(7, 1, 0);
        System.out.println(res);
    }
}
