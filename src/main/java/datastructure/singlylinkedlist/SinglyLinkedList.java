package datastructure.singlylinkedlist;

import java.util.ArrayList;

class Node {
    int val;
    Node next;

    public Node(int value) {
        val = value;
        next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.val;
    }

    private void addFirst(Node node) {
        head = node;
        tail = node;
        size++;
    }

    public void insertHead(int val) {
        Node node = new Node(val);

        if (head == null) {

            addFirst(node);
            return;
        }

        node.next = head;
        head = node;
        size++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);

        if (tail == null) {
            addFirst(node);
            return;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        Node previousNode = head;
        Node nodeToRemove = head;

        for (int i = 0; i < index; i++) {
            previousNode = nodeToRemove;
            nodeToRemove = nodeToRemove.next;
        }

        previousNode.next = nodeToRemove.next;
        size--;

        if (size == index) {
            tail = previousNode;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        Node currentHead = head;
        ArrayList<Integer>  values = new ArrayList<>();

        while (currentHead != null) {
            values.add(currentHead.val);
            currentHead = currentHead.next;
        }

        return values;
    }
}