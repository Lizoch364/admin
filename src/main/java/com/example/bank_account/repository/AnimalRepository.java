package com.example.bank_account.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.bank_account.model.Animal;

@Repository
public class AnimalRepository {
  private final Map<Integer, Animal> animals = new HashMap<>();

  public Optional<Animal> getById(int id) {
    return Optional.ofNullable(animals.get(id));
  }

  public List<Animal> getAll() {
    return new ArrayList<>(animals.values());
  }

  public void save(Animal animal) {
    animals.put(animal.getId(), animal);
  }

  public void delete(int id) {
    animals.remove(id);
  }
}
