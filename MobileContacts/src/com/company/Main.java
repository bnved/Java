package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("7327017102");

    public static void main(String[] args) {
	    boolean quit = false;

	    startPhone();
	    printActions();

	    while(!quit){
            System.out.println("\n Enter your action: (6 to show the available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Shutting Down...");
                    break;
                case 1:
                    // we can also do // mobilePhone.PrintContacts()
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    quit = true;
                    break;


            }
        }
    }
    private static void printContacts(){
        mobilePhone.printContacts();
    }

    public static void startPhone(){
        System.out.println("Phone is starting....");
    }

    public static void printActions(){
        System.out.println("\n available action \n press");
        System.out.println("0 - Shutdown the phone");
        System.out.println("1 - To print contacts");
        System.out.println("2 - To add new contacts");
        System.out.println("3 - To update existing contacts");
        System.out.println("4 - To remove an existing contact");
        System.out.println("5 - To query if an existing contact exists");
        System.out.println("6 - To print the available actions");

        System.out.println("Choose your action:");
    }

    private static void addNewContact(){
        System.out.println("Enter the New contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number:");
        String number = scanner.nextLine();

        Contacts newContact = Contacts.createContacts(name, number);

        if(mobilePhone.addNewContact(newContact)){
            System.out.println(name + " added as a new contact to the contacts. Phone number -->> " + number );
        }else{
            System.out.println("Cannot add contact it already exists.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter the contact you want to update:");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);

        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter the new number:");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContacts(newName, newNumber);

        if(mobilePhone.updateContact(existingContact, newContact)){
            System.out.println("Contact Updated Successfully");
        }else{
            System.out.println("Error adding the contact...");
        }
    }
    private static void removeContact() {
        System.out.println("Enter the contact you want to update:");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully Deleted");
        }else{
            System.out.println("Error while Deleting");
        }
    }
    private static void queryContact() {
        System.out.println("Enter the contact you want to update:");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name:" + existingContact.getName() + " Number -->> " + existingContact.getPhoneNumbers());
    }
}
