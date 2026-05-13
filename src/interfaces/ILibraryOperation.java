package interfaces;

import models.Book;

public interface ILibraryOperation {
    void addBook(Book book);
    void removeBook(int id);
    Book searchBook(int id);
    void listBooks();
}
