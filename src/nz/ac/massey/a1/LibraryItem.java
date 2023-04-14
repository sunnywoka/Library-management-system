//Yuekai Wu 13113181

package nz.ac.massey.a1;

import java.time.LocalDate;

//Father class LibraryItem
public abstract class LibraryItem {
    //data field
    private final String type;
    private final int id;
    private final String title;
    private final int year;
    protected int numberOfReviewers = 0;
    protected double averageRatingNumberOfReviews = 0;
    protected String status = "available";
    protected LocalDate date = LocalDate.now();;
    protected LocalDate dueDate;
    protected int maxNumberOfDaysForBorrowing;
//constructor
    public LibraryItem(String type, int id, String title, int year){
        this.type = type;
        this.id = id;
        this.title = title;
        this.year = year;
    }
//methods
    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void displayItemInfo(){
        System.out.println("--------------------------------------");
        System.out.printf("Type: %s\n", getType());
        System.out.printf("Title: %s\n", getTitle());
        System.out.printf("ID: %d\n", getId());
        System.out.printf("Year: %d\n", getYear());
        System.out.printf("Average rating: %.1f\n", averageRatingNumberOfReviews);
        System.out.printf("Number of reviewers: %d\n", numberOfReviewers);
        System.out.printf("Status: %s\n", status);
        if(status.equals("on loan")){
            System.out.println("Due date: " + dueDate);
        }
    }
}
