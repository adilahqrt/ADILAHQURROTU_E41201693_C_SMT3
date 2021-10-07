package com.example.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Schedule implements Parcelable {

//    Membuat private variabel
    private String title;
    private String group;
    private String schedule;
    private String sks;
    private String semester;
    private String dosen;
    private String deskripsi;

//    Menambahkan adapter
    public Schedule(String title, String group, String schedule, String sks, String semester, String dosen, String deskripsi) {
        this.title = title;
        this.group = group;
        this.schedule = schedule;
        this.sks = sks;
        this.semester = semester;
        this.dosen = dosen;
        this.deskripsi = deskripsi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.group);
        dest.writeString(this.schedule);
        dest.writeString(this.sks);
        dest.writeString(this.semester);
        dest.writeString(this.dosen);
        dest.writeString(this.deskripsi);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.group = source.readString();
        this.schedule = source.readString();
        this.sks = source.readString();
        this.semester = source.readString();
        this.dosen = source.readString();
        this.deskripsi = source.readString();
    }

    protected Schedule(Parcel in) {
        this.title = in.readString();
        this.group = in.readString();
        this.schedule = in.readString();
        this.sks = in.readString();
        this.semester = in.readString();
        this.dosen = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel source) {
            return new Schedule(source);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };
}
