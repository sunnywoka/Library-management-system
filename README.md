# Library-management-system

A library management system for books, journals and movies.

The library has three categories of items that can be borrowed: Books, Journals, and Movies. For each item, the library keeps track of its type, ID, title, year of publication, average rating, number of reviews, and maximum borrowing period (28 days for books, 14 days for journals, and 7 days for movies). If an item is currently borrowed, the due date is also recorded. In addition, the library records the author and number of pages for books, the director for movies, and the volume and number for journals.

The text file looks like:

```
Movie,200,Remember The Alamo,1945,George Smith
Movie,203,Lord of the ring: the fellowship of the ring,2001,Pete Jackson
Movie,206,Lord of the ring: the two towers,2002,Peter Jackson
Movie,210,Going for the Touchdown,1984,Frank Madden
Movie,211,Martian Hairdresser,1992,Debbie Gold
Book,231,How to Make Money,1987,Phil Barton,324
Book,240,Garden Projects At Home,1998,Mary Freeman,164
Book,202,The Haunted House Mystery,1996,Bert Morgan,53
Journal,207,ACM,2009,6,8
Journal,212,ACM,2010,5,8
Journal,215,J of Logic,2008,23,14
Journal,231,J of AI,2009,35,1

```

The program looks like:

```
--------------------------------------
Type: Movie
Title: Remember The Alamo
ID: 200
Year: 1945
Average rating: 0.0
Number of reviewers: 0
Status: available
Director: George Smith
Max number of days for borrowing: 7
--------------------------------------
--------------------------------------
Type: Movie
Title: Lord of the ring: the fellowship of the ring
ID: 203
Year: 2001
Average rating: 0.0
Number of reviewers: 0
Status: available
Director: Pete Jackson
Max number of days for borrowing: 7
--------------------------------------
.
.
.
Enter 'q' to quit, enter 'i' to search by ID, or enter any other to search by phrase in title
Enter 'q' to quit, enter 'i' to search by ID, or enter any other to search by phrase in title
i
Enter ID to start search, or enter 'b' to go back to choose search method
211
--------------------------------------
Type: Movie
Title: Martian Hairdresser
ID: 211
Year: 1992
Average rating: 0.0
Number of reviewers: 0
Status: available
Director: Debbie Gold
Max number of days for borrowing: 7
--------------------------------------
Enter 'i' to search other item by ID, or enter any other key to select this item
s

Selected item is
--------------------------------------
Type: Movie
Title: Martian Hairdresser
ID: 211
Year: 1992
Average rating: 0.0
Number of reviewers: 0
Status: available
Director: Debbie Gold
Max number of days for borrowing: 7
--------------------------------------
Enter 'b' to borrow the item, enter 'a' to rate the item, or enter any other key to restart
b
The item's due date is 2023-04-21

Selected item is
--------------------------------------
Type: Movie
Title: Martian Hairdresser
ID: 211
Year: 1992
Average rating: 0.0
Number of reviewers: 0
Status: on loan
Due date: 2023-04-21
Director: Debbie Gold
Max number of days for borrowing: 7
--------------------------------------
Enter 'r' to return the item, enter 'a' to rate the item, or enter any other key to restart
r
The item is returned

Selected item is
--------------------------------------
Type: Movie
Title: Martian Hairdresser
ID: 211
Year: 1992
Average rating: 0.0
Number of reviewers: 0
Status: available
Director: Debbie Gold
Max number of days for borrowing: 7
--------------------------------------
Enter 'b' to borrow the item, enter 'a' to rate the item, or enter any other key to restart
a
Please enter your rateing (0-10)
7
The item's new average rating is7.0
.
.
.
Enter 'q' to quit, enter 'i' to search by ID, or enter any other to search by phrase in title
q
Program quit.

```
