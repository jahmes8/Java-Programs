public class phonebookManager {

    protected static listNode head;
    protected static listNode current;
    protected int index;
    protected static int size;



    public static int size() {
        size = 0;
        current = head;

        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public listNode get(int index) throws NullPointerException {

        current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
        
    }
    

    // ADD METHOD WIP
    public void add(String firstName, String lastName, String address,
    String city, String number) throws NullPointerException {

        listNode node = new listNode(firstName, lastName, address, city, number);


        if (head == null) {
            head = node;
        }
        else {
            current = head;
            while (current.next != null) {
                current = current.next;
                }
                current.next = node;
                }
        } // end of add method



    // PRINT METHOD
    public void print() {
        for (int i = 0; i < size(); i++) {
            listNode node = get(i);
            System.out.println(node.toString());
        }
    }

    // WIP
    public class sort (phonebook) {
   

    }


    // delete method
    public void delete(String lastName) throws NullPointerException {
        
        listNode node;

        if (current.next != null) {

            for (int i = 0; i < size(); i++) {
                node = get(i);
                if (node == head && node.getLastName().equalsIgnoreCase(lastName)) {
                    head = head.next;
                }
                else if (node.next == null && node.getLastName().equalsIgnoreCase(lastName)) {
                    node = get(i-1);
                    node.next = null;
                }
                else if (node.getLastName().equalsIgnoreCase(lastName)) {
                node = get(i-1);
                node.next = node.next.next;
                }
                }
                }
        }






    public void modifyLastName(String lastName, String newLastName) {

        for (int i = 0; i < size(); i++) {
            listNode node = get(i);
            if (node.getLastName().equalsIgnoreCase(lastName)) {
                node.setLastName(newLastName);
            }
        }
    }
}
