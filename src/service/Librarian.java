package service;

import interfaces.IPayment;
import model.Book;
import model.MemberRecord;
import model.Person;
import model.Reader;

public class Librarian extends Person implements IPayment {
    private String password;

    public Librarian(String name, String password){
        super(name);
        this.password = password;
    }

    public void searchBook(int id){
        System.out.println(id + " ID'li kitap veritabanında sorgulanıyor...");
    }

    public boolean verifyMember(MemberRecord memberRecord){
        if(memberRecord != null){
            System.out.println("Üye doğrulandı: " + memberRecord.getName());
            return true;
        }
        System.out.println("Geçersiz üye kaydı!");
        return false;
    }

    public void issueBook(MemberRecord memberRecord, Book book){
        if(verifyMember(memberRecord) && memberRecord.getNoBooksIssued() < memberRecord.getMaxBookLimit() && book.isStatus()){
            memberRecord.incBookIssued();
            book.setStatus(false);
            System.out.println("İşlem Başarılı: " + book.getName() + " kitabı " + memberRecord.getName() + " kişisine teslim edildi.");
        } else {
            System.out.println("İşlem Başarısız: Kitap müsait değil veya üye, limitine ulaştı.");
        }
    }

    public double calculateFine(int daysOverdue){
        double finePerDay = 5;
        double totalFine = daysOverdue * finePerDay;
        System.out.println("Gecikme Süresi: " + daysOverdue + " gün. Toplam Ceza: " + totalFine + " TL.");
        return totalFine;
    }

    public void processReturn(Reader reader, Book book, Library library) {
        library.takeBackBook(reader, book);
        this.refundBill(reader, book); // İade makbuzu keser
    }

    @Override
    public void createBill(Reader reader, Book book){
        System.out.println("---- FATURA OLUŞTURULDU ----");
        System.out.println("Üye: " + reader.getName());
        System.out.println("Kitap: " + book.getName());
        System.out.println("Tutar: " + book.getPrice() + " TL");
    }

    @Override
    public void refundBill(Reader reader, Book book){
        System.out.println("---- İADE İŞLEMİ VE ÜCRET İADESİ ----");
        System.out.println(book.getName() + " iade alındı. Ücret iadesi yapıldı.");
    }

    @Override
    public void whoYouAre(){
        System.out.println("Görevli Kütüphaneci: " + getName());
    }

    // Getter
    public String getPassword() {
        return password;
    }

    //Setter
    public void setPassword(String password) {
        this.password = password;
    }
}
