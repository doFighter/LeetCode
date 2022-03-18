/**
 * @Description
 * @author Fighter
 * @create 2022-03-18 10:08
 */


package day26;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */

public class DeleteDuplicates {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 如果为空节点或者只有一个节点，直接返回
        if (head == null || head.next == null){
            return head;
        }

        // 先确定头节点位置，如果头节点就无法找到，直接返回null
        int temp = -101;
        while (head.val == temp || head.val == head.next.val){
            temp = head.val;
            head = head.next;
            if (head.next == null){
                if (head.val != temp){
                    return head;
                }else {
                    return null;
                }
            }
        }

        //对后续节点进行去重，使用temp记住前一节点值，后一节点用链表的方式访问
        ListNode node2 = head;
        ListNode node1 = head.next;
        while (node1.next != null){
            if (node1.val != temp && node1.val != node1.next.val){
                node2.next = node1;
                node2 = node2.next;
            }
            temp = node1.val;
            node1 = node1.next;
        }
        if (node1.val == temp){
            node2.next = null;
        }else {
            node2.next = node1;
        }
        return head;
    }
}
