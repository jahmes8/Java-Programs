
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
public class DictionaryTest {
    

    public static void main (String[] args) {

    DictionaryManager dictionary = new DictionaryManager(0, null,
     null, null, null, null, null, null, null);

    MenuManager menu = new MenuManager(0, null, null, null, 
    null, null, null, null, null);

    dictionary.add(4, "nam", "le", null, null, 
    null, null, null, null);

    dictionary.add(4, "test1", "le", null, null, 
    null, null, null, null);
    
    menu.mainMenu(dictionary);

    }
}
