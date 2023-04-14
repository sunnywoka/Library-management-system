//Yuekai Wu 13113181

package nz.ac.massey.a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements libraryAction{//Main.java hierarchies the interface libraryAction.java
    int m = 0;
    LibraryItem[] libraryItem = new LibraryItem[100];//declare the object array of libraryItem
    List<String> idList = new ArrayList<>();//declare the ArrayList to store libraryItem.id
    List<String> titleList = new ArrayList<>();//declare the ArrayList to store libraryItem.title

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public Main(){
        //Usw scanner to read the information from text file
        Scanner scanner;
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("library.txt")));
            String item;
            try{
                while(scanner.hasNextLine()){
                    item = scanner.nextLine();
                    String[] parts = item.split(",");
                    //Java polymorphism
                    if(parts[0].equals("Movie")){
                        libraryItem[m] = new Movies(parts[0], Integer.parseInt(parts[1]), parts[2], Integer.parseInt(parts[3]), parts[4]);
                        m++;
                        idList.add(parts[1]);
                        titleList.add(parts[2]);
                    }else if(parts[0].equals("Book")){
                        libraryItem[m] = new Books(parts[0], Integer.parseInt(parts[1]), parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]));
                        m++;
                        idList.add(parts[1]);
                        titleList.add(parts[2]);
                    }else{
                        libraryItem[m] = new Journals(parts[0], Integer.parseInt(parts[1]), parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                        m++;
                        idList.add(parts[1]);
                        titleList.add(parts[2]);
                    }
                }
            }finally {
                scanner.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        //print information of all libraryItem
        for(int i=0; i<=m; i++){
            try{
                libraryItem[i].displayItemInfo();
            }
            catch(NullPointerException ignored){
            }
        }
        System.out.println();
        search();
    }
    //override the method from interface
    @Override
    public void search() {
        System.out.println("Enter 'q' to quit, enter 'i' to search by ID, or enter any other to search by phrase in title");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        if (enter.equals("q")) {
            System.out.println("Program quit.");
            System.exit(0);
        }else if(enter.equals("i")) {//Users choose search in ID or phrase in title
            searchID();
        }else{
            searchPhraseInTitle();
        }
    }
    //override the method from interface
    @Override
    public void searchID() {
        System.out.println("Enter ID to start search, or enter 'b' to go back to choose search method");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        if (!enter.equals("b")) {
            for (int i = 0; i < m; i++) {
                if (enter.equals(idList.get(i))) {
                    libraryItem[i].displayItemInfo();
                    System.out.println("Enter 'i' to search other item by ID, or enter any other key to select this item");
                    input = new Scanner(System.in);
                    enter = input.nextLine();
                    if (enter.equals("i")) {
                        searchID();
                    } else {
                        select(i);
                    }
                    return;
                }
            }
            System.out.printf("There is no item with ID %s Restart search\n", enter);
        }
        search();
    }
    //override the method from interface
    @Override
    public void searchPhraseInTitle() {
        System.out.println("Enter phrase in title to start search, or enter 'b' to go back to choose search method");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        List<Integer> checkList = new ArrayList<>();
        int k = 1;
        if (!enter.equals("b")) {
            for (int i = 0; i < m; i++) {
                String[] parts = libraryItem[i].getTitle().split(" ");
                for (String part : parts) {
                    if (part.equals(enter)) {
                        System.out.printf("* %d", k);
                        libraryItem[i].displayItemInfo();
                        k++;
                        checkList.add(i);
                    }
                }
            }
            if(k!=1){
                System.out.println("Enter item number to select item, or enter any other key to continue searching");
                input = new Scanner(System.in);
                enter = input.nextLine();
                if(isNumeric(enter)){
                    int enterNum = Integer.parseInt(enter);
                    select(checkList.get(enterNum-1));
                }else{
                    searchPhraseInTitle();
                }

            }else{
                System.out.printf("There is no item with phrase %s Restart search\n", enter);
            }
        }
        search();
    }
    //override the method from interface
    @Override
    public void select(int i) {
        System.out.println();
        System.out.println("Selected item is");
        libraryItem[i].displayItemInfo();
        if(libraryItem[i].status.equals("available")){//users can borrow or return libraryItem by its status
            borrow(i);
        }else{
            returnItem(i);
        }
    }
    //override the method from interface
    @Override
    public void borrow(int i) {
        System.out.println("Enter 'b' to borrow the item, enter 'a' to rate the item, or enter any other key to restart");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        if(enter.equals("b")) {
            System.out.println("The item's due date is " + libraryItem[i].dueDate);
            libraryItem[i].status = "on loan";
            select(i);
        }else if(enter.equals("a")) {//Users can choose to rate libraryItem
            rateItem(i);
        }else{
            search();
        }
    }
    //override the method from interface
    @Override
    public void returnItem(int i) {
        System.out.println("Enter 'r' to return the item, enter 'a' to rate the item, or enter any other key to restart");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        if (enter.equals("r")) {
            System.out.println("The item is returned");
            libraryItem[i].status = "available";
            select(i);
        } else if (enter.equals("a")) {//Users can choose to rate libraryItem
            rateItem(i);
        } else {
            search();
        }
    }
    //override the method from interface
    @Override
    public void rateItem(int i) {
        System.out.println("Please enter your rateing (0-10)");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        double total = libraryItem[i].averageRatingNumberOfReviews * libraryItem[i].numberOfReviewers + Double.parseDouble(enter);
        libraryItem[i].numberOfReviewers++;
        libraryItem[i].averageRatingNumberOfReviews = total/libraryItem[i].numberOfReviewers;
        System.out.println("The item's new average rating is"+libraryItem[i].averageRatingNumberOfReviews);
        select(i);//back to select item option
    }


    public static void main(String[] args) {
        new Main();
    }
}
