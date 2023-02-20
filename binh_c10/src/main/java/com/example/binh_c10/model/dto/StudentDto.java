package com.example.binh_c10.model.dto;

public class StudentDto {
    private int id;
    private String name;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String classRoom;

    public StudentDto(int id, String name, String dob, String address, String phone, String email, String classRoom) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public StudentDto(int id, String name, String address, String classRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classRoom = classRoom;
    }

    public StudentDto(String name, String dob, String address, String phone, String email, String classRoom) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public StudentDto() {
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
