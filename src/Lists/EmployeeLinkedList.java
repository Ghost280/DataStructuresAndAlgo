package Lists;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(Employee employee){
      EmployeeNode node = new EmployeeNode(employee);
      node.setNext(head);
      head = node;
      size++;
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        EmployeeNode current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    public EmployeeNode retriveAtIndex(int index) {
        EmployeeNode current = head;
        if (index >= size) return null;
        int counter = 0;
        while (current != null) {
            if(counter == index) {
                return current;
            }
            current = current.getNext();
            counter ++;
        }
        return null;

    }

    public EmployeeNode removeFromFront() {
        EmployeeNode current = head;
        EmployeeNode nodeToBeRemoved;
        nodeToBeRemoved = current;
        head = head.getNext();
        nodeToBeRemoved.setNext(null);
        size --;
        return nodeToBeRemoved;
    }
    public void printLL(){
        EmployeeNode current = head;
        System.out.print("head -> ");
        while(current != null) {
            System.out.print(current + "-> ");
            current = current.getNext();
        }
        System.out.println("");
    }
} 
