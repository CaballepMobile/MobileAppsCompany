package com.example.admin.daily4week2;

import android.os.Parcel;
import android.os.Parcelable;

public class Celebrity implements Parcelable {
    private String Name;
    private String Description;
    private String PictureResFile;

    protected Celebrity(Parcel in) {
        Name = in.readString();
        Description = in.readString();
        PictureResFile = in.readString();
    }

    public static final Creator<Celebrity> CREATOR = new Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel in) {
            return new Celebrity(in);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPictureResFile() {
        return PictureResFile;
    }

    public void setPictureResFile(String pictureResFile) {
        PictureResFile = pictureResFile;
    }

    public Celebrity(String name, String description, String pictureResFile) {
        Name = name;
        Description = description;
        PictureResFile = pictureResFile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Description);
        parcel.writeString(PictureResFile);
    }
}
