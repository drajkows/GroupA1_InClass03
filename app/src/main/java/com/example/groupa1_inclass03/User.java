package com.example.groupa1_inclass03;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{
    String name;
    String email;
    int ID;
    String department;

    public User(String name, String email, int ID, String department){
        this.name = name;
        this. email = email;
        this.ID = ID;
        this.department = department;
    }
    public User(){

    }

    protected User(Parcel in){
        name = in.readString();
        email = in.readString();
        ID = in.readInt();
        department = in.readString();
    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeInt(this.ID);
        dest.writeString(this.department);
    }

}//end of class
