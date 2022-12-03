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

import java.util.Scanner;

public class MenuManager extends DictionaryManager {

    private String response;
    protected int newKey;
    private String newFirstName;
    private String newLastName;
    private String newAddress;
    private String newCity;
    private String newState;
    private String newZip;
    private String newEmail;
    private String newNumber;


    // CONSTRUCTOR
    public MenuManager(int key, String firstName, String lastName, String address, String city, String state,
    String zip, String email, String number) {
        super(key, firstName, lastName, address, city, state, zip, email, number);
        response = "";
    }



    // MAIN MENU METHOD
    public void mainMenu(DictionaryManager dictionary) {
        while (!response.equalsIgnoreCase("C")) { 
            response = menu(response);
            switch(response.toUpperCase()) {
                case "A":
                caseA(dictionary);
                break;
                case "D":
                caseD(dictionary);
                break;
                case "M":
                caseM(dictionary);         
                break;
                case "L":
                caseL(dictionary);
                break;
                case "P":
                caseP(dictionary);
                break;
                case "C":
                 System.out.println("You closed the program!");
                break;
                default:
                System.out.println("Please enter a valid command!");
            } // end of switch
        }
    }



    // MENU METHOD
    public String menu(String response) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter one of the following commands:");
        System.out.println("'add' to add a entry");
        System.out.println("'delete' to delete an entry");
        System.out.println("'modify' to modify an entry");
        System.out.println("'lookup' to lookup an employee");
        System.out.println("'print' to print the dictionary");
        System.out.println("'close' to close the program");
        response = input.next();
        response = response.substring(0,1);
        return response;
    }

    

    // CASE A METHOD, ADDS A NEW NODE
    public void caseA(DictionaryManager dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the key: ");
        key = input.nextInt();
        System.out.println("Please enter the first name: ");
        newFirstName = input.next();
        System.out.println("Please enter the last name: ");
        newLastName = input.next();
        System.out.println("Please enter the address: ");
        newAddress = input.next();
        System.out.println("Please enter the city: ");
        newCity = input.next();
        System.out.println("Please enter the state: ");
        newState = input.next();
        System.out.println("Please enter the zip: ");
        newZip = input.next();
        System.out.println("Please enter the email: ");
        newEmail = input.next();
        System.out.println("Please enter the phone number: ");
        newNumber = input.next();
        dictionary.add(key, newFirstName, newLastName, newAddress, 
        newCity, newState, newZip, newEmail, newNumber);
        System.out.println("\nEntry successfull!");
    }



    // CASE D METHOD, DELETES A NODE
    public void caseD(DictionaryManager dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the key of the employee you" +
        " wish to delete:");
        newKey = input.nextInt();
        if (dictionary.contains(newKey) == true) {
            dictionary.remove(newKey);
            System.out.println("\nEntry successfully deleted!");
        } else {
            System.out.println("\nEntry not found!");
        }
    }


    // CASE M METHOD, MODIFIES AN EXISTING NODE
    public void caseM(DictionaryManager dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the key of the employee's information you" +
        " wish to modify:");
        newKey = input.nextInt();
        if (dictionary.contains(newKey) == true) {
            modifyHelper(dictionary, newKey, newFirstName, newLastName, newAddress, newCity,
             newState, newZip, newEmail, newNumber);
        } else {
            System.out.println("\nEntry not found!");
        }

    }

    public void modifyHelper(DictionaryManager dictionary, int newKey, String newFirstName, String newLastName, String newAddress,
    String newCity, String newState, String newZip, String newEmail, String newNumber) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new first name:");
        newFirstName = input.next();
        System.out.println("Enter the new last name:");
        newLastName = input.next();
        System.out.println("Enter the new address:");
        newAddress = input.next();
        System.out.println("Enter the new city:");
        newCity = input.next();
        System.out.println("Enter the new state:");
        newState = input.next();
        System.out.println("Enter the new zip:");
        zip = input.next();
        System.out.println("Enter the new email:");
        email = input.next();
        System.out.println("Enter the new number:");
        number = input.next();
        dictionary.modify(newKey, newFirstName, newLastName, newAddress, newCity, newState, 
        newZip, newEmail, newNumber);
    }



    // CASE L, LOOK UP A NODE
    public void caseL(DictionaryManager dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the key of the employee you" +
        " wish to lookup:");
        newKey = input.nextInt();
        if (dictionary.contains(newKey) == true) {
            dictionary.printNode(newKey);
        } else {
            System.out.println("\nEntry not found!");
        }
    }



    // CASE P, PRINT OUT ALL NODES
    public void caseP(DictionaryManager dictionary) {
        response = printHelper();
        switch(response.toUpperCase()) {
            case "PR":
                dictionary.printPre();
                break;
            case "IN":
                dictionary.printIn();
                break;
            case "PO":
                dictionary.printPost();
                break;
            default:
                System.out.print("\nEnter a valid command!\n");
            }
        }

    public String printHelper() {
        Scanner input = new Scanner(System.in);
        System.out.println("'Pre' for pre-order");
        System.out.println("'In' for in-order");
        System.out.println("'post' for post-order");
        response = input.next();
        response = response.substring(0,2);
        return response;
    }

} // end of class
