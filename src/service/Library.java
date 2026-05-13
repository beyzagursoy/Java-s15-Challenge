package service;

import interfaces.ILibraryOperation;
import model.Book;
import model.MemberRecord;
import model.Reader;

import java.util.*;

public class Library implements ILibraryOperation {
    private Map<Integer, Book> booksMap;
    private Set<Integer> bookIDs;
    private List<Reader> readers;

    public Library(){
        this.booksMap = new HashMap<>();
        this.bookIDs = new HashSet<>();
        this.readers = new ArrayList<>();
    }

    @Override
    public void addBook(Book book){
        if(bookIDs.add(book.getBookID())){
            booksMap.put(book.getBookID(), book);
            System.out.println("Sistem: '" + book.getName() + "' başarıyla eklendi.");
        } else {
            System.out.println("Hata: " + book.getBookID() + " ID'li kitap zaten mevcut!");
        }
    }

    @Override
    public void removeBook(int id){
        if(booksMap.containsKey(id)){
            Book removedBook = booksMap.remove(id);
            bookIDs.remove(id);
            System.out.println("Sistem: '" + removedBook.getName() + "' (ID: " + id + ") silindi.");
        } else {
            System.out.println("Hata: Silinmek istenen " + id + " ID'li kitap bulunamadı.");
        }
    }

    @Override
    public Book searchBook(int id){
        return booksMap.get(id);
    }

    @Override
    public void listBooks(){
        System.out.println("--- Kütüphane Kitap Listesi ---");
        if(booksMap.isEmpty()){
            System.out.println("Kütüphane şu an boş.");
        } else {
            for(Book book : booksMap.values()){
                book.display();
            }
        }
    }

    public void lendBook(Reader reader, Book book){
        if(book.isStatus()){
            reader.borrowBook(book);
        } else {
            System.out.println("Hata: Kitap şu an ödünç verilmiş durumda.");
        }
    }

    public void takeBackBook(Reader reader, Book book) {
        reader.returnBook(book);
        book.setStatus(true);
        System.out.println("Sistem: '" + book.getName() + "' iade alındı ve rafa eklendi.");
    }

    // İsimle kitap ara
    public void searchByTitle(String title) {
        booksMap.values().stream()
                .filter(book -> book.getName().equalsIgnoreCase(title))
                .forEach(Book::display);
    }

    // Yazara göre
    public void listByAuthor(String authorName) {
        booksMap.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .forEach(Book::display);
    }

    // Kategoriye göre
    public void listByCategory(String category) {
        for (Book book : booksMap.values()) {
            if (book.getClass().getSimpleName().equalsIgnoreCase(category)) {
                book.display();
            }
        }
    }

    public void addReader(Reader reader){
        readers.add(reader);
    }

    public List<Reader> getReaders(){
        return readers;
    }

}
