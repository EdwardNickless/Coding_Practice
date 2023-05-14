/**
 * A class that keeps details about
 * a book such as Title or Author.
 *
 * @author Edward Nickless
 * @version 12.10.2021
 * 
 * Question 1(a)
 */

import java.util.Iterator;

/**
 * Question 1(b)
 */
public class Book
{
    
    private String author;

    private String title;

    private String id;

    private boolean onLoan;

    /**
     * Sets the fields (author, title, id and onLoan) when
     * the object is constructed.
     * 
     * Question 1(c)
     */
    public Book(String anAuthor, String aTitle, String anId)
    {
        author = anAuthor;
        title = aTitle;
        id = anId;
        onLoan = false;
    }

    /**
     * Returns the name of the Author of the book.
     * 
     * Question 1(d)(i)
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Returns the title of the book.
     * 
     * Question 1(d)(i)
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the id of the book.
     * 
     * Question 1(d)(i)
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns whether the book is on loan or not
     * as a boolean value.
     * 
     * Question 1(d)(i)
     */
    public boolean isOnLoan()
    {
        return onLoan;
    }

    /**
     * Sets the value of the onLoan boolean.
     * 
     * Question 1(d)(ii)
     */
    public void setOnLoan(boolean available)
    {
        onLoan = available;
    }

    /**
     * Return a string that describes the book in question.
     * 
     * Question 1(e)
     */
    public String toString()
    {
        String bookDetails = "Title: ";
        bookDetails = bookDetails + title;
        bookDetails = bookDetails + ", Author: ";
        bookDetails = bookDetails + author;
        bookDetails = bookDetails + " (";
        if (onLoan == false)
        {
            bookDetails = bookDetails + "available)";
        }
        else {
            bookDetails = bookDetails + "on loan)";
        }
        return bookDetails;
    }

    /**
     * Returns whether the book has a valid identifier.
     * 
     * Question 1(f)
     */
    public boolean verifyId()
    {
        int index = 0;
        int total = 0;
        boolean isValid = false;
        while(index < id.length()) {
            total += id.charAt(index) % 10;
            index++;
        }
        if(total % 7 == 0 && id.length() != 0) {
            isValid = true;
        }
        return isValid;
    }

}
