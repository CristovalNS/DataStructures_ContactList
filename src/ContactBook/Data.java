package ContactBook;

import java.util.LinkedList;

public class Data{
    // Attributes
    public String name;
    public String phoneNumber;
    public String email;

    // Constructor
    public Data(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Methods

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
