/**
 * @Description
 * @author Fighter
 * @create 2022-03-19 10:25
 */


package day27;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */

public class Tree2str {


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder builder = new StringBuilder();

    public void recursion(TreeNode note){
        if (note.left == null && note.right != null){
            builder.append("()(");
            builder.append(note.right.val);
            recursion(note.right);
            builder.append(')');
            return;
        }
        if (note.left != null){
            builder.append("("+note.left.val);
            recursion(note.left);
            builder.append(')');
        }
        if (note.right != null){
            builder.append("("+note.right.val);
            recursion(note.right);
            builder.append(')');
        }
    }


    public String tree2str(TreeNode root) {
        if (root != null){
            builder.append(root.val);
        }
        recursion(root);
        return builder.toString();
    }
}
