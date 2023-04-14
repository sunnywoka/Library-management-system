//Yuekai Wu 13113181

package nz.ac.massey.a1;

//Child class Movies hierarchies father class LibraryItem
public class Movies extends LibraryItem{
    //data field
    private String director;
    //constructor
    public Movies(String type, int id, String title, int year, String director){
        super(type, id, title, year);//from father class
        this.maxNumberOfDaysForBorrowing = 7;
        this.dueDate = super.date.plusDays(maxNumberOfDaysForBorrowing);
        this.director = director;
    }
    //child class method
    public String getDirector() {
        return director;
    }
    //override method which is same in father class
    @Override
    public void displayItemInfo(){
        super.displayItemInfo();//will call displayItemInfo from father class
        System.out.printf("Director: %s\n", getDirector());
        System.out.printf("Max number of days for borrowing: %d\n", maxNumberOfDaysForBorrowing);
        System.out.println("--------------------------------------");
    }
}
