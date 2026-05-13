package models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private List<Book> books; //Composition

    public Reader(String name){
        super(name);
        this.books = new ArrayList<>();
    }


    public void purchaseBook(Book book){
        System.out.println(getName() + ", " + book.getName() + " kitabı satın aldı.");
    }

    public void borrowBook(Book book){
        books.add(book);
    }

    public void returnBook(Book book){
        if(books.remove(book)){
            book.setStatus(true); // kitap kütüphaneye geri verildi.
            System.out.println(book.getName() + " iade edildi.");
        }
    }

    public void showBook(){
        System.out.println("---- " + getName() + " Üzerindeki kitaplar ----");
        if(books.isEmpty()){
            System.out.println("Henüz kitap almadınız.");
        } else {
            books.forEach(Book::display);
        }
    }

    @Override
    public void whoYouAre(){
        System.out.println("Ben bir okuyucuyum: " + getName());
    }

    //Getter
    public List<Book> getBooks(){
        return books;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "books=" + books +
                '}';
    }
}
