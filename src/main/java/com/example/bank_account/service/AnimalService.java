package com.example.bank_account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_account.model.Animal;
import com.example.bank_account.repository.AnimalRepository;

@Service
public class AnimalService {
  private AnimalRepository animalRepository;

  public Animal getById(int id) {
    Optional<Animal> animal = animalRepository.getById(id);

    if (animal.isEmpty()) {
      throw new RuntimeException("Хозяин с id = " + id + " не найден");
    }

    return animal.get();
  }

  public List<Animal> getAll() {
    return animalRepository.getAll();
  }

  public void create(Animal animal) {
    animalRepository.save(animal);
  }

  public void delete(int id) {
    animalRepository.delete(id);
  }

  @Autowired
  public void setAnimalRepository(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }
}
