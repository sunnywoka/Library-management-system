//Yuekai Wu 13113181

package nz.ac.massey.a1;

//Child class Journals hierarchies father class LibraryItem
public class Journals extends LibraryItem{
    //data field
    private int volumeForJournals;
    private int numberForJournals;
    //constructor
    public Journals(String type, int id, String title, int year, int volumeForJournals, int numberForJournals){
        super(type, id, title, year);//from father class
        this.maxNumberOfDaysForBorrowing = 14;
        this.dueDate = super.date.plusDays(maxNumberOfDaysForBorrowing);
        this.volumeForJournals = volumeForJournals;
        this.numberForJournals = numberForJournals;
    }
    //child class method
    public int getNumberForJournals() {
        return numberForJournals;
    }

    public int getVolumeForJournals() {
        return volumeForJournals;
    }
    //override method which is same in father class
    @Override
    public void displayItemInfo(){
        super.displayItemInfo();//will call displayItemInfo from father class
        System.out.printf("Volume: %d\n", getVolumeForJournals());
        System.out.printf("Number: %d\n", getNumberForJournals());
        System.out.printf("Max number of days for borrowing: %d\n", maxNumberOfDaysForBorrowing);
        System.out.println("--------------------------------------");
    }
}
