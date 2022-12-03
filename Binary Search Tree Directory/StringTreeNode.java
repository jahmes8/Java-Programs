package Dictionary;

public class StringTreeNode {
    
    protected StringTreeNode right;
    protected StringTreeNode left;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;
    protected String email;
    protected String number;
    protected int key;

    
    // CONSTRUCTOR, sets paramether values to the node's value
    public StringTreeNode(int key, String firstName, String lastName, String address,
    String city, String state, String zip, String email, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.number = number;
        this.key = key;
    }


    public String toString() {
        return "Employee: " + key + " | " + firstName +
        " " + lastName + " ---- " + address + ", " +
        city + " " + state + " " + zip + "| Contact: " +
        email + " " + number;
    }


    //----------{SET METHODS}----------\\


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

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNumber(String number) {
        this.number = number;
    }

} // end of class
