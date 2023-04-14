//Yuekai Wu 13113181

package nz.ac.massey.a1;

//Interface libraryAction declare all methods for main.java
public interface libraryAction {
    void search();
    void searchID();
    void searchPhraseInTitle();
    void select(int i);
    void borrow(int i);
    void returnItem(int i);
    void rateItem(int i);
}
