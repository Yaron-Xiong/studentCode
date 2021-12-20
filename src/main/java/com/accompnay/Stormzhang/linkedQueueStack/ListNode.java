package com.accompnay.Stormzhang.linkedQueueStack;

public class ListNode {
	int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
