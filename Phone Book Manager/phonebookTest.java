import java.util.*;

public class phonebookTest {

    public static void main (String[] args) {


        phonebookManager phonebook = new phonebookManager();

        phonebook.add("nam", "a", "asd", "adsa", "wadsd");
        phonebook.add("james", "b", "asd", "adsa", "wadsd");
        phonebook.add("asdas", "le", "asd", "adsa", "wadsd");
        phonebook.add("asdas", "c", "asd", "adsa", "wadsd");
        phonebook.add("balj","a","asd","adsa","wadsd");


        phonebook.print();
    }       
}
