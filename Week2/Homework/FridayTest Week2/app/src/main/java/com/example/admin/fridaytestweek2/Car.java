package com.example.admin.fridaytestweek2;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private int CarId;
    private String Model;
    private String Type;
    private String Year;

    public Car(int carId, String model, String type, String year) {
        CarId = carId;
        Model = model;
        Type = type;
        Year = year;
    }

    protected Car(Parcel in) {
        CarId = in.readInt();
        Model = in.readString();
        Type = in.readString();
        Year = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(CarId);
        parcel.writeString(Model);
        parcel.writeString(Type);
        parcel.writeString(Year);
    }
}