//Yuekai Wu 13113181

package nz.ac.massey.a1;

//Child class Books hierarchies father class LibraryItem
public class Books extends LibraryItem{
    //data field
    private String author;
    private int numberOfPages;
//constructor
    public Books(String type, int id, String title, int year, String author, int numberOfPages){
        super(type, id, title, year);//from father class
        this.maxNumberOfDaysForBorrowing = 28;
        this.dueDate = super.date.plusDays(maxNumberOfDaysForBorrowing);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }
    //child class method
    public String getAuthor(){
        return author;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }
//override method which is same in father class
    @Override
    public void displayItemInfo(){
        super.displayItemInfo();//will call displayItemInfo from father class
        System.out.printf("Author: %s\n", getAuthor());
        System.out.printf("Number of pages: %d\n", getNumberOfPages());
        System.out.printf("Max number of days for borrowing: %d\n", maxNumberOfDaysForBorrowing);
        System.out.println("--------------------------------------");
    }
}
