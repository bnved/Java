package com.company;

public class Contacts {
    private String name;
    private String phoneNumbers;

    public Contacts(String name, String phoneNumbers){
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName(){
        return name;
    }
    public String getPhoneNumbers(){
        return phoneNumbers;
    }

    public static Contacts createContacts(String name, String phoneNumbers){

        return new Contacts(name, phoneNumbers);
    }
}
