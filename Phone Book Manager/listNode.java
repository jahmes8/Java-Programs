public class listNode {
    
    protected listNode head;
    protected listNode next;
    protected listNode current;
    protected String firstName;
    protected String lastName;
    protected String number;
    protected String city;
    protected String address;

    public listNode(String firstName, String lastName, String address, 
    String city, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.number = number;
    } // end of ListNode constructor


    // TO STRING METHOD
    public String toString() {
        return "| "+ lastName + " " + firstName + " ---- " +
        address + ", " + city + " ---- " + number + " |";

    }

    // GET METHODS
    public String getLastName(){
        return this.lastName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getNumber(){
        return this.number;
    }

    // SET METHODS
    public void setLastName(String setLastName) {
        this.lastName = setLastName;
    }

    public void setFirstName(String setFirstName) {
        this.firstName = setFirstName;
    }

    public void setAddress(String setAddress) {
        this.address = setAddress;
    }

    public void setCity(String setCity) {
        this.city = setCity;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
