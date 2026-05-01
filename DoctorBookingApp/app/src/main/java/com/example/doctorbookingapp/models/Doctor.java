package com.example.doctorbookingapp.models;

public class Doctor {

    public String name;
    public String specialty;
    public String degree;
    public int image;

    public Doctor(String name, String specialty, String degree, int image) {
        this.name = name;
        this.specialty = specialty;
        this.degree = degree;
        this.image = image;
    }
}