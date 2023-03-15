package ContactBook;

import java.util.LinkedList;

public class Add {
    // Attributes
    public String name;
    public String phoneNumber;
    public String email;
    private LinkedList<Data> contactList; // Reference to the linked list

    // Constructor
    public Add(String name, String phoneNumber, String email, LinkedList<Data> contactList) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.contactList = contactList;
    }

    // Methods
    public String AddMethod() {
        for (Data contact : contactList) {
            if (contact.getName().equals(name)) { // Check if contact with the same name already exists
                return "A contact with the same name already exists. Please enter a different name.";
            }
        }
        Data newData = new Data(name, phoneNumber, email);
        contactList.add(newData); // Add the new data to the linked list
        return "New contact added: " + name + " " + phoneNumber + " " + email;
    }
}
