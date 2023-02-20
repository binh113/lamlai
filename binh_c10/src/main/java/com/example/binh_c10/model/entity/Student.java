package com.example.binh_c10.model.entity;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String classRoom;

    public Student(int id, String name, String dob, String address, String phone, String email, String classRoom) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(String name, String dob, String address, String phone, String email, String classRoom) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
