package ua.kh.tremtyachiy.shoping.util;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/**
 * Created by User on 12.06.2015.
 */

public class Adress {
    private String nameCompany;
    private String adres;
    private Drawable pictureCompany;
    private String phone;
    private String fullTimeOfCompany;

    public Adress(String nameCompany, String adres, Drawable pictureCompany, String phone, String fullTimeOfCompany) {
        this.nameCompany = nameCompany;
        this.adres = adres;
        this.pictureCompany = pictureCompany;
        this.phone = phone;
        this.fullTimeOfCompany = fullTimeOfCompany;
    }

    public String getPhone() {
        return phone;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getAdres() {
        return adres;
    }

    public Drawable getPictureCompany() {
        return pictureCompany;
    }

    public String getFullTimeOfCompany() {
        return fullTimeOfCompany;
    }
}
