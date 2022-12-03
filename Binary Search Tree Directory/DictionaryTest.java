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
