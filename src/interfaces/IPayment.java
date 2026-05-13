package interfaces;

import models.Book;
import models.Reader;

public interface IPayment {
    void createBill(Reader reader, Book book);
    void refundBill(Reader reader, Book book);
}
