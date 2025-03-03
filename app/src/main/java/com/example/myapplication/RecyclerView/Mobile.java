package com.example.myapplication.RecyclerView;

public class Mobile {
    private String mobileName;
    private String mobileCompany;
    private String mobilePrice;

    public Mobile(String mobileName, String mobileCompany, String mobilePrice) {
        this.mobileName = mobileName;
        this.mobileCompany = mobileCompany;
        this.mobilePrice = mobilePrice;
    }

    public Mobile() {
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getMobileCompany() {
        return mobileCompany;
    }

    public void setMobileCompany(String mobileCompany) {
        this.mobileCompany = mobileCompany;
    }

    public String getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(String mobilePrice) {
        this.mobilePrice = mobilePrice;
    }
}
