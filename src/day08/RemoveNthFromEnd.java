/**
 * @Description
 * @author Fighter
 * @create 2022-02-14 18:05
 */


package day08;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */

public class RemoveNthFromEnd {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nPrior = head;
        ListNode deletePrior = head;
        for (int i=0;i<n;i++){
            if (nPrior.next == null){
                return head.next;
            }
            nPrior = nPrior.next;
        }
        while (nPrior.next != null){
            deletePrior = deletePrior.next;
            nPrior = nPrior.next;
        }
        deletePrior.next = deletePrior.next.next;
        return head;
    }
}
