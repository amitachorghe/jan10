import java.util.Scanner;

public class linkedlist {
    static class Node {
        public int data;
        public Node next;
        public Node temp;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public void addNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;
            tail = newNode;
        } else {

            tail.next = newNode;

            tail = newNode;
        }
    }

    static Node GetNode(int data) {
        return new Node(data);
    }

    static Node InsertPos(Node headNode, int position, int data) {
        Node head = headNode;
        if (position < 1)
            System.out.print("Invalid position");

        if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = headNode;
            head = newNode;
        } else {
            while (position-- != 0) {
                if (position == 1) {

                    Node newNode = GetNode(data);

                    newNode.next = headNode.next;

                    headNode.next = newNode;
                    break;
                }
                headNode = headNode.next;
            }
            if (position != 1)
                System.out.print("Position out of range");
        }
        return head;
    }

    void deleteNode(int position) {

        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

    public void searchNode(int data) {
        Node current = head;
        int i = 1;
        boolean flag = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {

                if (current.data == data) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if (flag)
            System.out.println("Element is present in the list at the position : " + i);
        else
            System.out.println(-1);
        System.out.println("Element is not present in the list");
    }

    public void display(Node current) {

        // Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of current singly linked list: ");
        while (current != null) {

            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void NewHead(int newhead) {

        for (int i = 0; i < newhead; i++) {
            head = head.next;
        }
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of current singly linked list: ");

        while (current != null) {

            System.out.print(current.data + " ");
            current = current.next;

        }

        System.out.println();

    }

    public static void main(String[] args) {

        linkedlist sList = new linkedlist();

        System.out.print("Enter the number of nodes :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // int j = i+1;
            System.out.print("Enter node" + " " + i + " " + "data: ");
            int b = sc.nextInt();
            sList.addNode(b);
        }

        System.out.println();
        System.out.println(
                "[1] Insert a node , [2] Delete a node, [3] Search an element, [4] Display the Linked list , [5] Display the Linked list from a given Index");
        System.out.print("Enter the Choice number :");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter the index position to Insert new node :");
                int ikey = sc.nextInt();
                if (ikey < n) {
                    System.out.print("Enter the data :");
                    int data = sc.nextInt();
                    head = InsertPos(head, ikey, data);
                    sList.display(head);
                } else {
                    System.out.println("Index position out of bound, Number of nodes in Linked list is :" + n);
                }
                break;

            case 2:
                System.out.print("Enter the Index of the node to be deleted :");
                int dkey = sc.nextInt();
                if (dkey < n && dkey >= 0) {
                    sList.deleteNode(dkey);
                    sList.display(head);
                } else {
                    System.out.println("Index position out of bound, Number of nodes in Linked list is :" + n);
                }
                break;

            case 3:

                System.out.println("Enter the element to search :");
                int skey = sc.nextInt();
                sList.searchNode(skey);
                break;

            case 4:
                sList.display(head);
                break;

            case 5:
                System.out.println("Enter the Head Node Position :");
                int newhead = sc.nextInt();
                if (newhead < n) {
                    sList.NewHead(newhead);
                } else {
                    System.out.println("Index position out of bound, Number of nodes in Linked list is :" + n);
                }
                break;
            default:
                System.out.print("Invalid Choice Number :");

        }

    }
}