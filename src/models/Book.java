package models;

import java.util.Objects;

public abstract class Book {
    private int bookID;
    private String author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private String dateOfPurchase;

    public Book(int bookID, String author, String name, double price, boolean status, String edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = true;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    //abstract metod
    public abstract void display();

    //Getter
    public int getBookID() {
        return bookID;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    //Setter
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookID);
    }

    @Override
    public String toString() {
        return "Book{ID=" + bookID + ", Name='" + name + "'}";
    }
}
