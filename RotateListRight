public ListNode rotateRight(ListNode head, int k) {
        if(head ==null)
        {
            return null;
        }
        int i = 1;
        ListNode current = head;
        while(current.next!=null)
        {
            i++;
            current=current.next;
        }
        current.next = head;
        k = k %i;
        int stepsToNewHead = i - k;

        ListNode newTail = head;
        for (int j = 1; j < stepsToNewHead; j++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
