package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        var node0 = new ListNode(3);
        var node1 = new ListNode(2);
        var node2 = new ListNode(0);
        var node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        var result = solution.hasCycle(node0);

        assertThat(result).isTrue();
    }

    @Test
    void example2() {
        var node0 = new ListNode(1);
        var node1 = new ListNode(2);

        node0.next = node1;
        node1.next = node0;

        var result = solution.hasCycle(node0);

        assertThat(result).isTrue();
    }

    @Test
    void example3() {
        var node0 = new ListNode(1);

        var result = solution.hasCycle(node0);

        assertThat(result).isFalse();
    }
}
