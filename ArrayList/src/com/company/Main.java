package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstruction();
        while(!quit){
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    printInstruction();
                    break;
                case 2:
                    groceryList.printGroceryList();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    modifyItem();
                    break;
                case 5:
                    removeItem();
                    break;
                case 6:
                    searchItem();
                    break;
                default:
                    quit = true;
                    break;

            }
        }

    }

    public static void printInstruction(){
        System.out.println("\nPress ");
        System.out.println("\t 1 - To print choices options.");
        System.out.println("\t 2 - To print the list of grocery item");
        System.out.println("\t 3 - To add item to the list.");
        System.out.println("\t 4 - To modify an item in the list.");
        System.out.println("\t 5 - To remove item from the list.");
        System.out.println("\t 6 - To search item in the list.");
        System.out.println("\t Press any of the remaining key to exit from the application.");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery item:");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Enter the item number: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the item you want to modify: ");
        String newItem = scanner.nextLine();

        groceryList.modifyGroceryItem(position-1,newItem);
    }

    public static void removeItem(){
        System.out.println("Enter the Index you want remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        groceryList.removeGroceryItem(index);
    }

    public static void searchItem(){
        System.out.println("Enter the Item you want to search:");
        String lookFor = scanner.nextLine();

        if(groceryList.findItem(lookFor) != null){
            System.out.println("Item found in the list");
        }else {
            System.out.println("Item not found");
        }
    }
}
