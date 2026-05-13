package model;

import java.util.Date;

public abstract class MemberRecord {
    private int memberID;
    private String type;
    private Date dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(int memberID, String type, Date dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = new Date();
        this.noBooksIssued = 0;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public abstract void payBill();

    public void incBookIssued(){
        this.noBooksIssued++;
    }

    public void decBookIssued(){
        this.noBooksIssued--;
    }

    //Getter
    public int getMemberID() {
        return memberID;
    }

    public String getType() {
        return type;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    //Setter
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
