/**
 * A class that contains a collection of books.
 * This class depends on the class Book.
 *
 * @author Edward Nickless
 * @version 04.12.2021
 * 
 * Question 2(a)
 */

/**
 * Question 2(b)
 */

import java.util.ArrayList;

import java.util.Iterator;

public class Library
{
    private ArrayList<Book> books;

    private String name;

    /**
     * Sets the name field and initialises an empty
     * ArrayList called books when the object is constructed.
     * 
     * Question 2(c)
     */
    public Library(String aName)
    {
        name = aName;
        books = new ArrayList<Book>();
    }

    /**
     * Adds a new object of type Book to the
     * ArrayList books.
     * 
     * Question 2(d)(i)
     */
    public void addBook(String anAuthor, String aTitle, String anId)
    {
        Book newBook = new Book(anAuthor, aTitle, anId);
        books.add(newBook);
    }

    /**
     * Calculates a late return fine based on
     * 2 percent of the cost of the book
     * multiplied by the number of days late.
     * 
     * Question 2(d)(ii)
     */
    public double calculateFine(double aBookPrice, int aNumberOfDays)
    {
        double dailyCost = ((aBookPrice * 2) / 100);
        double fine = dailyCost * aNumberOfDays;
        return fine;
    }

    /**
     * Searches the library and returns
     * an ArrayList of books that match
     * the given book title.
     * 
     * Question 2(d)(iii)
     */
    public ArrayList<Book> getMatchingBooks(String aTitle)
    {
        ArrayList<Book> matchingBooks = new ArrayList<Book>();
        int index = 0;
        while(index < books.size()) {
            Book book = books.get(index);
            String title = book.getTitle();
            if(aTitle == title){
                matchingBooks.add(book);
            }
            index++;
        }
        return matchingBooks;
    }

    /**
     * Returns whether a book in the library is available
     * or not. A book is available only if the given book is
     * owned by the library and is not already on loan.
     * 
     * Question 2(d)(iv)
     */
    public boolean isAvailable(Book aBook)
    {
        Book myBook = aBook;
        boolean searching = true;
        boolean isAvailable = false;
        int index = 0;
        while(searching && index < books.size()) {
            Book libBook = books.get(index);
            if(myBook.getTitle() == libBook.getTitle() && libBook.isOnLoan() == false) {
                isAvailable = true;
            }
            index++;
        }
        return isAvailable;
    }
    
    /**
     * Prints out lines of text containing 
     * the details of all of the books
     * owned by the library.
     * 
     * Question 2(d)(v)
     */
    public void listAllBooks()
    {
        int index = 0;
        while(index < books.size()) {
            System.out.println(books.get(index));
            index++;
        }
    }
    
    /**
     * Searches through the books owned by the library for the given
     * book and sets the first matching books onLoan status to true.
     * Does nothing if a matching book is not found.
     * 
     * Question 2(d)(vi)
     */
    public void loanBook(Book aBook)
    {
        boolean searching = true;
        Book myBook = aBook;
        int index = 0;
        while(searching && index < books.size()) {
            Book libraryBook = books.get(index);
            if(myBook.getId() == libraryBook.getId()) {
                books.get(index).setOnLoan(true);
                searching = false;
            }
            index++;
        }
    }
    
    /**
     * Searches through the books owned by the library
     * for the given book. The first matching book then
     * removed from the library. If no matching book is
     * found then a message is printed to inform the user.
     * 
     * Question 2(d)(vii)
     */
    public void removeBook(Book aBook)
    {
        Iterator<Book> it = books.iterator();
        boolean present = false;
        while(it.hasNext()) {
            Book b = it.next();
            if (aBook.getId() == b.getId()) {
                it.remove();
                present = true;
            }
        }
        if(present == false) {
            System.out.println("Book not found");
        }
    }
}