package ContactBook;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class ContactBook {

    public static void main(String[] args) {
        LinkedList<Data> contactList = new LinkedList<Data>(); // Create a linked list
        Scanner scn = new Scanner(System.in);
        int counter = 1;
        String option_name, option_PN, option_Email;
        String option = "";

        System.out.println("Welcome to your Contact Book!");

        while (!option.equals("Q")) {
            System.out.println("What would you like to do?");
            System.out.println("******************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)Email Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("******************************");
            System.out.print("Selected option = ");

            option = scn.nextLine();

            switch (option) {
                case "A":
                    System.out.println("Enter their contact details: ");

                    System.out.print("Name: ");
                    option_name = scn.nextLine();

                    while (Objects.equals(option_name, "")) {
                    System.out.println("Please enter a valid name.");
                    System.out.print("Name: ");
                    option_name = scn.nextLine();
                    }

                    System.out.print("Phone Number: ");
                    option_PN = scn.nextLine();

                    while (Objects.equals(option_PN, "")) {
                        System.out.println("Please enter a valid phone number.");
                        System.out.print("Phone Number: ");
                        option_PN = scn.nextLine();
                    }

                    System.out.print("Email: ");
                    option_Email = scn.nextLine();

                    while (Objects.equals(option_Email, "")) {
                        System.out.println("Please enter a valid email.");
                        System.out.print("Email: ");
                        option_Email = scn.nextLine();
                    }

                    Add new_contact = new Add(option_name, option_PN, option_Email, contactList);
                    System.out.println(new_contact.AddMethod());
                    break;

                case "D":
                    System.out.println("Current list of contacts: ");
                    System.out.println("Name | Phone Number | Email");
                    for (Data contact : contactList) {
                        System.out.println(counter + ". " + contact.getName() + " | " + contact.getPhoneNumber() + " | " + contact.getEmail());
                        counter++;
                    }
                    System.out.println("******************************");
                    System.out.println("Type the contact name that you want to delete: ");
                    option = scn.nextLine();

                    boolean deleted = false;
                    for (Data contact : contactList) {
                        if (contact.getName().equals(option)) {
                            contactList.remove(contact);
                            System.out.println("Contact deleted: " + option);
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Contact not found: " + option);
                    }
                    counter = 1;
                    break;

                case "E":
                    System.out.print("Enter the email of the contact: ");
                    option = scn.nextLine();

                    boolean emailFound = false;
                    for (Data contact : contactList) {
                        if (contact.getEmail().equals(option)) {
                            System.out.println("Email belongs to contact = " + contact.getName() + " | "
                                    + contact.getPhoneNumber() + " | " + contact.getEmail());
                            emailFound = true;
                            break;
                        }
                    }

                    if (!emailFound) {
                        System.out.println("No contact with the given email was found.");
                    }

                    break;

                case "P":
                    System.out.println("List of contacts added: ");
                    System.out.println("Name | Phone Number | Email");
                    for (Data contact : contactList) {
                        System.out.println(counter + ". " + contact.getName() + " | "
                                + contact.getPhoneNumber() + " | " + contact.getEmail());
                        counter++;
                    }
                    counter = 1;
                    System.out.println("******************************");
                    break;

                case "S":
                    System.out.print("Enter the Name of the contact: ");
                    option = scn.nextLine();

                    boolean nameFound = false;
                    for (Data contact : contactList) {
                        if (contact.getName().equals(option)) {
                            System.out.println("Contact with that name exists = " + contact.getName() + " | "
                                    + contact.getPhoneNumber() + " | " + contact.getEmail());
                            nameFound = true;
                            break;
                        }
                    }

                    if (!nameFound){
                        System.out.println("No contact with the name was found.");
                    }
                    break;

                case "Q":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid input. Please enter the appropriate option.");
                    break;
            }
        }
    }
}
