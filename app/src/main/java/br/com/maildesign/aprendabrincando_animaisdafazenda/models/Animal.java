package br.com.maildesign.aprendabrincando_animaisdafazenda.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String aName;
    private String aTextBR;
    private String aTextEN;
    private String aTextES;

    public Animal(String name, String textBR, String textEN, String textES){
        aName = name;
        aTextBR = textBR;
        aTextEN = textEN;
        aTextES = textES;

    }

    private Animal (Parcel parcel){
        aName = parcel.readString();
        aTextBR = parcel.readString();
        aTextEN = parcel.readString();
        aTextES = parcel.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaTextBR() {
        return aTextBR;
    }

    public void setaTextBR(String aTextBR) {
        this.aTextBR = aTextBR;
    }

    public String getaTextEN() {
        return aTextEN;
    }

    public void setaTextEN(String aTextEN) {
        this.aTextEN = aTextEN;
    }

    public String getaTextES() {
        return aTextES;
    }

    public void setaTextES(String aTextES) {
        this.aTextES = aTextES;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(aName);
        dest.writeString(aTextBR);
        dest.writeString(aTextEN);
        dest.writeString(aTextES);
    }
}
