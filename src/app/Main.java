package app;

import models.*;
import models.Librarian;
import models.Library;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // --- Sistem Başlatma ---
        Library library = new Library();
        Librarian librarian = new Librarian("Beyza Gürsoy", "12345");
        Scanner scanner = new Scanner(System.in);

        // --- Giriş Paneli ---
        System.out.println("=== KÜTÜPHANE OTOMASYON SİSTEMİ ===");
        System.out.print("Görevli Adı: ");
        String inputName = scanner.nextLine();
        System.out.print("Sistem Şifresi: ");
        String inputPass = scanner.nextLine();

        if (inputName.equalsIgnoreCase(librarian.getName()) && inputPass.equals(librarian.getPassword())) {
            System.out.println("\nGiriş Başarılı! Hoş geldin, " + librarian.getName());
            librarian.whoYouAre();
        } else {
            System.out.println("Hata: Geçersiz kullanıcı adı veya şifre! Sistem kapatılıyor.");
            return;
        }

        // --- Örnek Başlangıç Verileri ---
        library.addBook(new StudyBooks(1, "Robert Sedgewick", "Algorithms", 150.0, true, "4th Ed", "2026-01-10"));
        library.addBook(new Magazines(2, "National Geographic", "Science Issue", 45.0, true, "May 2026", "2026-05-01"));
        library.addBook(new Journals(3, "IEEE", "Quantum Computing", 200.0, true, "Vol 12", "2026-03-15"));

        Student studentMember = new Student(1, "Student", new Date(), 0, 5, "Ali Can", "Burdur/Merkez", "0555");
        Reader reader = new Reader(studentMember.getName());
        library.addReader(reader);

        System.out.println("=== Kütüphane Yönetim Sistemine Hoş Geldiniz ===");
        boolean running = true;

        while (running) {
            System.out.println("\n--- ANA MENÜ ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil");
            System.out.println("3. Kitap Ara (ID)");
            System.out.println("4. Kitap Ara (İsim)");
            System.out.println("5. Tüm Kitapları Listele");
            System.out.println("6. Yazara Göre Kitapları Listele");
            System.out.println("7. Kategoriye Göre Listele");
            System.out.println("8. Kitap Bilgilerini Güncelle");
            System.out.println("9. Kitap Ödünç Al");
            System.out.println("10. Kitap İade Et");
            System.out.println("11. Kullanıcı ve Limit Bilgilerimi Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Kitap Ekle
                    System.out.print("Kitap Türü (1: Ders Kitabı, 2: Dergi, 3: Journal): ");
                    int type = scanner.nextInt();
                    System.out.print("ID: "); int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("İsim: "); String bName = scanner.nextLine();
                    System.out.print("Yazar/Yayıncı: "); String bAuthor = scanner.nextLine();
                    System.out.print("Fiyat: "); double bPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Edisyon: "); String bEd = scanner.nextLine();

                    if (type == 1) library.addBook(new StudyBooks(id, bAuthor, bName, bPrice, true, bEd, "2026-05-13"));
                    else if (type == 2) library.addBook(new Magazines(id, bAuthor, bName, bPrice, true, bEd, "2026-05-13"));
                    else library.addBook(new Journals(id, bAuthor, bName, bPrice, true, bEd, "2026-05-13"));
                    break;

                case 2: // Kitap Sil
                    System.out.print("Silinecek Kitap ID: ");
                    library.removeBook(scanner.nextInt());
                    break;

                case 3: // ID ile Ara
                    System.out.print("Aranacak Kitap ID: ");
                    Book foundById = library.searchBook(scanner.nextInt());
                    if (foundById != null) foundById.display();
                    else System.out.println("Kitap bulunamadı.");
                    break;

                case 4: // İsimle Ara
                    System.out.print("Aranacak Kitap İsmi: ");
                    library.searchByTitle(scanner.nextLine());
                    break;

                case 5: // Tümünü Listele
                    library.listBooks();
                    break;

                case 6: // Yazara Göre Listele
                    System.out.print("Yazar Adı: ");
                    library.listByAuthor(scanner.nextLine());
                    break;

                case 7: // Kategoriye Göre Listele
                    System.out.print("Kategori (StudyBooks/Magazines/Journals): ");
                    library.listByCategory(scanner.nextLine());
                    break;

                case 8: // Güncelleme
                    System.out.print("Güncellenecek Kitap ID: ");
                    Book uBook = library.searchBook(scanner.nextInt());
                    if (uBook != null) {
                        System.out.println("1: İsim, 2: Yazar, 3: Fiyat");
                        int uChoice = scanner.nextInt(); scanner.nextLine();
                        if(uChoice == 1) { System.out.print("Yeni İsim: "); uBook.setName(scanner.nextLine()); }
                        else if(uChoice == 2) { System.out.print("Yeni Yazar: "); uBook.setAuthor(scanner.nextLine()); }
                        else if(uChoice == 3) { System.out.print("Yeni Fiyat: "); uBook.setPrice(scanner.nextDouble()); }
                        System.out.println("Güncellendi.");
                    } else System.out.println("Bulunamadı.");
                    break;

                case 9: // Ödünç Al
                    System.out.print("Ödünç Alınacak Kitap ID: ");
                    Book bToLend = library.searchBook(scanner.nextInt());
                    if (bToLend != null) {
                        librarian.issueBook(studentMember, bToLend);
                        if (!bToLend.isStatus()) {
                            reader.borrowBook(bToLend);
                            librarian.createBill(reader, bToLend);
                        }
                    }
                    break;

                case 10: // İade Et
                    System.out.print("İade Edilecek Kitap ID: ");
                    Book bToReturn = library.searchBook(scanner.nextInt());
                    if (bToReturn != null) {
                        librarian.processReturn(reader, bToReturn, library);
                        studentMember.decBookIssued();
                    }
                    break;

                case 11: // Bilgiler
                    studentMember.payBill(); // Polymorphism
                    reader.showBook();
                    System.out.println("Aktif Kitap Sayısı: " + studentMember.getNoBooksIssued());
                    System.out.println("Kalan Limit: " + (studentMember.getMaxBookLimit() - studentMember.getNoBooksIssued()));
                    break;

                case 0:
                    running = false;
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        scanner.close();
    }
}