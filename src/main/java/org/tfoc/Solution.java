package org.tfoc;

import java.util.Iterator;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode last = head;
        for (var outter : asIterable(iterator(head))) {
            for (var inner : asIterable(iterator(head))) {
                if (outter == inner) {
                    last = outter;
                    break;
                } else if (inner == last) {
                    return true;
                }
            }
        }

        return false;
    }

    private static Iterable<ListNode> asIterable(Iterator<ListNode> iterator) {
        return () -> iterator;
    }

    private static Iterator<ListNode> iterator(ListNode node) {
        return new Iterator<>() {
            private ListNode curr = node;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public ListNode next() {
                var tmp = curr;
                curr = curr.next;
                return tmp;
            }
        };
    }
}
