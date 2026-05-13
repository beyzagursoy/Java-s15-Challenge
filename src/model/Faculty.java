package model;

import java.util.Date;

public class Faculty extends MemberRecord{

    public Faculty(int memberID, String type, Date dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(memberID, "Faculty", dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo);
    }

    @Override
    public void payBill(){
        System.out.println("Fakülte üyesi ödeme işlemi tamamlandı. Kurumsal fatura kesildi.");
    }
}
