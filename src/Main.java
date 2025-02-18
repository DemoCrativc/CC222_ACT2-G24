import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int data;
    Node ref;
    public Node(int data){
        this.data = data;
        this.ref = null;
    }
}

class Linkedlist {
    Node head;

    public void insertAtStart(int data){
        Node newHead = new Node(data);
        newHead.ref = head;
        head = newHead;
    }

    public void insertAtEnd(int data){
        Node newHead = new Node(data);
        if(head==null){
            head = newHead;
        }else{
            Node t = head;

            while(t.ref != null){
                t = t.ref;
            }

            t.ref = newHead;
        }
    }

    public String display(){
        Node t = head;

        // StringBuilder result = new StringBuilder();
        String result = "";
        while(t != null){
            // result.append(t.data).append(" -> ");
            result += Integer.toString(t.data) + " -> ";
            t = t.ref;
        }

        // result.append("null");
        // return result.toString();
        result += "null";
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arrList = new ArrayList<>();
        Linkedlist linkList = new Linkedlist();

        while(true){
            System.out.print("Enter a value: ");
            int value = scanner.nextInt();
            
            System.out.println("Operations\n[1] Insert to the array\n[2] Insert to the linkedlist");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            boolean isInvalid = false;
            do{
                isInvalid = false;
                switch(choice) {
                    case 1:
                        arrList.add(value);
                        System.out.println("Array After Insertion: " +arrList);
                        break;
                    case 2:
                        do{
                            System.out.println("Insert " +value +" at:\n[1] Beginning\n[2] End\nChoice: ");
                            int insAt = scanner.nextInt();
                            isInvalid = false;

                            switch (insAt) {
                                case 1:
                                    linkList.insertAtStart(value);
                                    System.out.println("Linked list after insertion at beginning: " +linkList.display());
                                    break;
                                case 2:
                                    linkList.insertAtEnd(value);
                                    System.out.println("Linked list after insertion at end: " +linkList.display());
                                    break;
                                default:
                                    System.out.println("Invalid choice!\n");
                                    isInvalid = true;
                                    break;
                            }
                        }while(isInvalid);
                        break;
                    default:
                        System.out.println("Invalid choice!\n");
                        isInvalid = true;
                }

                do {
                    System.out.println("Options:\n[1] Enter a new value\n[2] END\nChoice: ");
                    int isEnding = scanner.nextInt();
                    if(isEnding == 1){
                        break;
                    }else if(isEnding == 2){
                        return;
                    }else{
                        System.out.println("Invalid Choice!\n");
                    }
                }while(true);
            }while(isInvalid);
            scanner.close();
        }
        
        // scanner.close();
    }
}
