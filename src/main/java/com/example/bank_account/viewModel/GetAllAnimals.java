package com.example.bank_account.viewModel;

import java.util.List;

import com.example.bank_account.model.Animal;

public record  GetAllAnimals (
  String title,
  List<Animal> animals
){}
