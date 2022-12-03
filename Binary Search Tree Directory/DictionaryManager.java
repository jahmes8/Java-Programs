
// Programmer: Nam Le & James Chen
// Date: 11/26/2022
// Class: CS 145
// Lab: Binary Search Tree

// Function: Create a dictionary using binary search tree to 
//           store information about employees and allow the
//           user to add, delete, print, modify, and lookup
//           specific employees.
//           


package Dictionary;

import java.util.NoSuchElementException;
import java.util.Random;

public class DictionaryManager extends StringTreeNode {

    protected StringTreeNode overallRoot;
    protected boolean contains;


    //CONSTRUCTOR
    public DictionaryManager(int key, String firstName, String lastName, 
    String address, String city, String state, String zip,
    String email, String number) {
        super(key, firstName, lastName, address, city, state, zip, 
        email, number);
        contains = false;
    }



    // ADD METHOD
    // PRE-CONDITION: INFORMATION ABOUT THE EMPLOYEE
    // POST-CONDITION: A NEW NODE INSIDE THE STRING BINARY SEARCH TREE
    public void add(int key, String firstName, String lastName, String address,
    String city, String state, String zip, String email, String number) {

        overallRoot = add(overallRoot, key, firstName, lastName, address, 
        city, state, zip, email, number);
    }

    // ADD METHOD, set as root if null, left child if less than root,
    // right child if greater than root, generate new key if same value.            
    private StringTreeNode add(StringTreeNode root, int key, 
    String firstName, String lastName, String address, String city, 
    String state, String zip, String email, String number) {
        
        if (root == null) {
            root = new StringTreeNode(key, firstName, lastName, address, 
            city, state, zip, email, number);
        }
        else if (root.key > key) {
            root.left = add(root.left, key, firstName, lastName, 
            address, city, state, zip, email, number);
        }
        else if (root.key < key) {
            root.right = add(root.right, key, firstName, lastName, 
            address, city, state, zip, email, number);
        }
        else {
            System.out.println("\nKey is in use!\nGenerating new key...");
            key = generateKey(key+1); // generates new key
            System.out.println("Your new key is: " + key);
            add(root, key, firstName, lastName, address, city, state, zip, email, number);
            // recalls add method again with new key
        }

        return root;

    }



    // REMOVE METHOD,
    // PRE-CONDITION: EMPLOYEE'S KEY
    // POST-CONDITION: REMOVES THE NODE FROM STRING BINARY SEARCH TREE
    public void remove(int key) {
        overallRoot = remove(overallRoot, key);
    }

    private StringTreeNode remove(StringTreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.key > key) {
            root.left = remove(root.left, key);
        } else if (root.key < key) {
            root.right = remove(root.right, key);
        } else { // root.key == key
            if (root.right == null) {
                return root.left; // return left root if no right child
            } else if (root.left == null) {
                return root.right;// return right root if no left child
            } else { // no child
                root.key = getMin(root.right); // get min from right child
                root.right = remove(root.right, root.key);
            }
        }
        return root;
    }



    // GET MIN METHOD, 
    // POST CONDITION: returns the minimum value from the String BST
    public int getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private int getMin(StringTreeNode root) {
        if (root.left == null) {
            return root.key;
        } else {
            return getMin(root.left);
        }
        
    }



    // CONTAINS METHOD,
    // POST-CONDITION: RETURNS TRUE IF STRING BST CONTAINS 
    // A NODE WITH KEY, OTHERWISE RETURN FALSE
    public boolean contains(int newKey) {
       return contains(overallRoot, newKey);
    }


    private boolean contains(StringTreeNode root, int newKey) {
        if (root == null) {
            return false;
        } else if (root.key == newKey) {
            return true;
        } else if (root.key > newKey) {
            return contains(root.left, newKey);
        } else {
            return contains(root.right, newKey);
        }
    }



    // PRINT NODE METHOD,
    // POST-CONDITION: PRINTS A SPECIFIC NODE USING INT KEY
    public void printNode(int newKey) {
        System.out.println();
        printNode(overallRoot, newKey);
    }

    public StringTreeNode printNode(StringTreeNode root, int newKey) {
        if (root.key == newKey) {
            System.out.println(root.toString());
        } else if (root.key > newKey) {
            root.left = printNode(root.left, newKey);
        } else {
            root.right = printNode(root.right, newKey);
        }
        return root;
    }



    // PRINT IN METHOD,
    // POST-CONDITION: PRINTS LEFT SUBTREE, ROOT NODE,
    // THEN RIGHT SUBTREE
    public void printIn() {
        System.out.println();
        printIn(overallRoot);
    }

    private void printIn(StringTreeNode root) {

        if (root != null) {
            printIn(root.left);
            System.out.println(root.toString());
            printIn(root.right);
        }
    }



    // PRINT PRE METHOD,
    // POST-CONDITION: PRINTS ROOT NODE, THEN ITS LEFT
    // AND RIGHT SUBTREES
    public void printPre() {
        System.out.println();
        printPre(overallRoot);
    }

    private void printPre(StringTreeNode root) {
        
        if (root != null) {
            System.out.println(root);
            printPre(root.left);
            printPre(root.right);
        }
    }


    // PRINT POST METHOD,
    // POST-CONDITION: PRINTS LEFT AND RIGHT SUBTREES,
    // THEN ROOT NODE
    public void printPost() {
        System.out.println();
        printPost(overallRoot);
    }

    private void printPost(StringTreeNode root) {
        
        if (root != null) {
            printPost(root.left);
            printPost(root.right);
            System.out.println(root);
        }
    }



    // GENERATE KEY METHOD,
    // POST-CONDITION: A NEW RANDOM KEY INT
    public int generateKey(int key) {
        int newKey = key;
        Random random = new Random();
        // adds 4 to random int bound
        key = random.nextInt(key+4)+1; //+1 to make it not 0
        if (newKey == key) {
            generateKey(key);
        }
        return key;
    }
    


    //----------{MODIFY METHODS}----------\\



    // MODIFY, 
    // PRE-CONDITION: EMPLOYEE'S INFORMATION AS PARAMETER
    // POST-CONDITION: MODIFIES AN EXISITNG NODE'S INFORMATION
    public void modify(int key, String newFirstName, String newLastName, String newAddress,
    String newCity, String newState, String newZip, String newEmail, String newNumber) {

        overallRoot = modify(overallRoot, key, newFirstName, newLastName, newAddress, 
        newCity, newState, newZip, newEmail, newNumber);
    }


    private StringTreeNode modify(StringTreeNode root, int key, String newFirstName, 
    String newLastName, String newAddress, String newCity, String newState, String newZip, 
    String newEmail, String newNumber) {

        if (root.key == key) { // modifies the node's information
            return root = modifyData(root, key, newFirstName, newLastName, newAddress, 
            newCity, newState, newZip, newEmail, newNumber);
        } else if (root.key > key) {
            root.left = modify(root.left, key, firstName, lastName, address, city, 
            state, zip, email, number);
        } else if (root.key < key) {
            root.right = modify(root.right, key, firstName, lastName, address, city, 
            state, zip, email, number);
        }
        
        return root;
    }


    // MODIFY DATA, modifies the root's information with new values.
    private StringTreeNode modifyData(StringTreeNode root, int key, String newFirstName, 
    String newLastName, String newAddress, String newCity, String newState, String newZip, 
    String newEmail, String newNumber) {
        
        root.setFirstName(newFirstName);
        root.setLastName(newLastName);
        root.setAddress(newAddress);
        root.setCity(newCity);
        root.setState(newState);
        root.setZip(newZip);
        root.setEmail(newEmail);
        root.setNumber(newNumber);

        return root;
    }
}
