package models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String name){
        super(name);
        this.books = new ArrayList<>();
    }

    public void newBook(Book book){
        if(!books.contains(book)){
            books.add(book);
            System.out.println(book.getName() + " isimli kitap, yazar " + getName() + " portfolyosuna eklendi.");
        }
    }

    public void showBook(){
        System.out.println("---- Yazar: " + getName() + " Tarafından Yazılan Kitaplar ----");
        if(books.isEmpty()){
            System.out.println("Bu yazarın henüz kayıtlı bir kitabı bulunmamaktadır.");
        } else {
            for(Book book : books){
                book.display();
            }
        }
    }

    @Override
    public void whoYouAre(){
        System.out.println("Ben bir yazarım. Adım: " + getName());
    }

    //Getter
    public List<Book> getBooks(){
        return books;
    }

    //Setter
    public void setBooks(List<Book> books){
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
