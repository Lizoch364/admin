package com.example.bank_account.model;

import java.util.ArrayList;
import java.util.List;

public class Owner {
  private int id;
  private String name;
  private String surname;
  private String phoneNumber;
  private List<Animal> animals;

  public Owner(int id, String name, String surname, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.animals = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAnimals(List<Animal> animals) {
    this.animals = animals;
  }

  public void addAnimal(Animal animal) {
    this.animals.add(animal);
  }
}
