package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<String, String> accounts = new HashMap<String, String>();
    //returns true if account exist and returns false if it doesn't
    public static boolean accountExist(String name){
        if(accounts.get(name)==null){
            return false;
        }
        return true;
    }
    //creates a new account with a username and password
    public static void createNewAccount(String name, String password){
        boolean exist = accountExist(name);
        if(!exist){
            accounts.put(name,password);
            System.out.println("Account has been created!");
        } else{
            System.out.println("An account already exists. Please choose a different username");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(1==1) {
            System.out.println("Welcome to Bank of Java!");
            System.out.println("1:Log in");
            System.out.println("2:Create a New Account");
            System.out.println("3:Exit");
            String option = sc.nextLine();
            //login
            if (option.equals("1")){
                boolean exit=true;
                System.out.println("Enter your username");
                int n = 3;
                while(n>=0) {
                    String name = sc.nextLine();
                    if (!accountExist(name)&&!name.equals("quit")) {
                        System.out.println("Username doesn't exist");
                        if(n>0) {
                            System.out.println("please try again! You have " + n + " attempts left");
                        } else{
                            System.out.println("exiting...");
                        }
                        n--;
                    }
                    if (accountExist(name)) {
                        System.out.println("Enter your password");
                        int b = 3;
                        while(b>=0) {
                            String password = sc.nextLine();
                            if (password.equals(accounts.get(name))) {
                                System.out.println("Welcome back " + name);
                                exit=false;
                                break;
                            }
                            if (!password.equals(accounts.get(name))) {
                                System.out.println("Password isn't correct");
                                if(b>0) {
                                    System.out.println("please try again! You have " + b + " attempts left");
                                } else{
                                    System.out.println("exiting...");
                                    exit=false;
                                    break;
                                }
                                b--;
                            }
                        }
                    }
                    if(!exit){
                        break;
                    }
                }
            }
            //create account
            if (option.equals("2")) {
                System.out.println("Choose you username");
                String name = sc.nextLine();
                if (accountExist(name)) {
                    System.out.println("your username isn't available. Please create a different one");
                }
                if (!accountExist(name)) {
                    System.out.println("Choose your password");
                    String password = sc.nextLine();
                    createNewAccount(name, password);
                }
            }
            //exit
            if (option.equals("3")){
                break;
            } if(option.equals("1")==false&&option.equals("2")==false&&option.equals("3")==false){
                System.out.println("Choose a valid number");
            }

        }
    }
}
