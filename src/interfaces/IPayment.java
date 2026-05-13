package interfaces;

import model.Book;
import model.Reader;

public interface IPayment {
    void createBill(Reader reader, Book book);
    void refundBill(Reader reader, Book book);
}
