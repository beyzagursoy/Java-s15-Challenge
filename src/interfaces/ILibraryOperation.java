package interfaces;

import model.Book;

public interface ILibraryOperation {
    void addBook(Book book);
    void removeBook(int id);
    Book searchBook(int id);
    void listBooks();
}
