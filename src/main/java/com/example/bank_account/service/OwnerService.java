package com.example.bank_account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_account.model.Animal;
import com.example.bank_account.model.Owner;
import com.example.bank_account.repository.AnimalRepository;
import com.example.bank_account.repository.OwnerRepository;

@Service
public class OwnerService {
  private OwnerRepository ownerRepository;
  private AnimalRepository animalRepository;

  public Owner getById(int id) {
    Optional<Owner> owner = ownerRepository.getById(id);

    if (owner.isEmpty()) {
      throw new RuntimeException("Хозяин с id = " + id + " не найден");
    }

    return owner.get();
  }

  public List<Owner> getAll() {
    return ownerRepository.getAll();
  }

  public void create(Owner owner) {
    ownerRepository.save(owner);
  }

  public void delete(int id) {
    ownerRepository.delete(id);
  }

  public void addAnimal(int ownerId, int animalId) {
    Optional<Owner> owner = ownerRepository.getById(ownerId);

    if (owner.isEmpty()) {
      throw new RuntimeException("Хозяин с id = " + ownerId + " не найден");
    }

    Optional<Animal> animal = animalRepository.getById(animalId);

    if (animal.isEmpty()) {
      throw new RuntimeException("Животное с id = " + animal + " не найдено");
    }

    owner.get().addAnimal(animal.get());

    ownerRepository.save(owner.get());
  }

  @Autowired
  public void setAnimalRepository(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Autowired
  public void setOwnerRepository(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }
}
