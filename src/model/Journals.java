package model;

public class Journals extends Book {

    public Journals(int bookID, String author, String name, double price, boolean status, String edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

    @Override
    public void display() {
        System.out.println("----- AKADEMİK JOURNAL BİLGİLERİ -----");
        System.out.println("ID: " + getBookID());
        System.out.println("İsim: " + getName());
        System.out.println("Yazar: " + getAuthor());
        System.out.println("Baskı: " + getEdition());
        System.out.println("Fiyat: " + getPrice() + " TL");
        System.out.println("Durum: " + (isStatus() ? "Kütüphanede" : "Ödünç Verildi"));
        System.out.println("---------------------------------");
    }
}