package model;

import java.util.Date;

public class Student extends MemberRecord{

    public Student(int memberID, String type, Date dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(memberID, "Student", dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo);
    }

    @Override
    public void payBill() {
        System.out.println("Öğrenci fatura ödemesi başarıyla gerçekleştirildi. İndirimli tarife uygulandı.");
    }
}
