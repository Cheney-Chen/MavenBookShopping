/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Amy
 */
public class Book implements Serializable ,Comparator,Comparable{
  
    private Integer book_ID;
    private String book_Name;
    private String book_Author;
    private String book_Publisher;
    private Integer book_Price;
    private Date Book_Date;

    /**
     * Get the value of Book_Date
     *
     * @return the value of Book_Date
     */
    public Date getBook_Date() {
        return Book_Date;
    }

    /**
     * Set the value of Book_Date
     *
     * @param Book_Date new value of Book_Date
     */
    public void setBook_Date(Date Book_Date) {
        this.Book_Date = Book_Date;
    }

    public Book(Integer ID, String name, String author, String publisher, Integer price) {
        this.book_ID = ID;
        this.book_Name = name;
        this.book_Author = author;
        this.book_Publisher = publisher;
        this.book_Price = price;
    }

    public Book(String name, String author, String publisher, Integer price) {
        this.book_Name = name;
        this.book_Author = author;
        this.book_Publisher = publisher;
        this.book_Price = price;
    }

  

   
    public Book() {
       
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public Integer getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(Integer book_ID) {
        this.book_ID = book_ID;
    }

    public String getBook_Name() {
        return book_Name;
    }

    public void setBook_Name(String book_name) {
        this.book_Name = book_name;
    }

    public String getBook_Author() {
        return book_Author;
    }

    public void setBook_Author(String book_author) {
        this.book_Author = book_author;
    }

    public String getBook_Publisher() {
        return book_Publisher;
    }

    public void setBook_Publisher(String book_publisher) {
        this.book_Publisher = book_publisher;
    }

    public Integer getBook_Price() {
        return book_Price;
    }

    public void setBook_Price(Integer book_price) {
        this.book_Price = book_price;
    }

   


  
    @Override
    public int compare(Object o1, Object o2) {
         //        Book obj=(Book) o1;
          //        Book obj=(Book) o2;
    if(o1 instanceof Book && o2 instanceof Book)  
    return((Book) o1).getBook_ID()-((Book) o2).getBook_ID();
        return 0;
    }

    @Override
    public int compareTo(Object o) {
//        Book obj=(Book) o;
        if(o instanceof Book)
    return this.book_ID - ((Book) o).getBook_ID();
    return 0;
    }

    //    @Override
    //    public boolean equals(Object o){
    //        if(o instanceof Book)
    //        return this.ID.equals(((Book) o).getID()) && this.name.equals(((Book)o).getName()) && this.author.equals(((Book) o).getAuthor());
    //        return false;
    //    }
    //
    //    @Override
    //    public int hashCode(){
    //        return this.ID.hashCode()*this.name.hashCode()*this.author.hashCode();
    //
    //    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.book_ID);
        hash = 11 * hash + Objects.hashCode(this.book_Name);
        hash = 11 * hash + Objects.hashCode(this.book_Author);
        hash = 11 * hash + Objects.hashCode(this.book_Publisher);
        hash = 11 * hash + Objects.hashCode(this.book_Price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.book_ID, other.book_ID)) {
            return false;
        }
        if (!Objects.equals(this.book_Name, other.book_Name)) {
            return false;
        }
        if (!Objects.equals(this.book_Author, other.book_Author)) {
            return false;
        }
        if (!Objects.equals(this.book_Publisher, other.book_Publisher)) {
            return false;
        }
        if (!Objects.equals(this.book_Price, other.book_Price)) {
            return false;
        }
        return true;
    }


}
