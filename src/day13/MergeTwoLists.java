/**
 * @Description
 * @author Fighter
 * @create 2022-02-20 16:47
 */


package day13;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */

public class MergeTwoLists {

//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head,temp,other;
        if (list1.val< list2.val){
            head = list1;
            temp = list1;
            other = list2;
        }else {
            head = list2;
            temp = list2;
            other = list1;
        }
        while (temp!=null && other!=null){
            while (temp.next !=null && temp.next.val<other.val){
                temp = temp.next;
            }
            ListNode node = other;
            other = other.next;
            node.next = temp.next;
            temp.next = node;
            temp = node;
        }
        return head;
    }

}
