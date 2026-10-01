package k_way_merge;

import java.util.*;

public class MergeKSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode[] convertListToLinkedList(int[][] matrix) {
        ListNode[] listNodes = new ListNode[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            if (row.length == 0) {
                listNodes[i] = null;
                continue;
            }

            ListNode head = new ListNode(row[0]);
            ListNode temp = head;

            for (int j = 1; j < row.length; j++) {
                temp.next = new ListNode(row[j]);
                temp = temp.next;
            }

            listNodes[i] = head;
        }

        return listNodes;
    }

    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.printf("%d -> ", temp.val);
            temp = temp.next;
        }
        System.out.print("end");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        ListNode temp = null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    return Integer.compare(a.val, b.val);
                });

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();

            if (head == null) {
                head = min;
                temp = head;
            } else {
                temp.next = min;
                temp = temp.next;
            }

            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 5 },
                { 1, 3, 4 },
                { 2, 6 }
        };

        ListNode[] listNodes = convertListToLinkedList(matrix);

        // for(ListNode listNode: listNodes){
        // display(listNode);
        // System.out.println();
        // }

        ListNode res = mergeKLists(listNodes);

        display(res);
    }
}
