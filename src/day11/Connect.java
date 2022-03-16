/**
 * @Description
 * @author Fighter
 * @create 2022-02-17 18:31
 */


package day11;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */

public class Connect {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 层次遍历：使用队列
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int size = 1;
        int cent = 0;
        while (!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            size--;
            if (size==0){
                cent++;
                size = (int) Math.pow(2,cent);
                node.next = null;
            }else {
                Node node1 = nodeQueue.peek();
                node.next = node1;
            }
            if (node.left != null){
                nodeQueue.offer(node.left);
            }
            if (node.right != null){
                nodeQueue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 借助节点中的next，通过next完成不同父节点的子节点相连接
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        root.next = null;
        Node temp = root;
        conTrees(temp);
        return root;
    }
    public void conTrees(Node node){
        if (node == null){
            return;
        }
        if (node.left !=null && node.right !=null){
            node.left.next = node.right;
        }
        if (node.next == null && node.right != null){
            node.right.next = null;
        }else if (node.right != null){
            node.right.next = node.next.left;
        }
        conTrees(node.left);
        conTrees(node.right);
    }
}
