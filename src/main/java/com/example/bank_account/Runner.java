package com.example.bank_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bank_account.model.Animal;
import com.example.bank_account.model.Owner;
import com.example.bank_account.repository.AnimalRepository;
import com.example.bank_account.repository.OwnerRepository;

@Component
public class Runner implements CommandLineRunner{
  private OwnerRepository ownerRepository;
  private AnimalRepository animalRepository;

  @Override
  public void run(String... args) throws Exception {
    animalRepository.save(new Animal(1, "Cat", "Sona"));
    animalRepository.save(new Animal(2, "Cat", "Ella"));
    animalRepository.save(new Animal(3, "Dog", "Elvis"));
    animalRepository.save(new Animal(4, "Bird", "Kesha"));
    animalRepository.save(new Animal(5, "Dog", "Plyto"));

    ownerRepository.save(new Owner(1, "Lisa", "Vasileva", "89957867511"));
    ownerRepository.save(new Owner(2, "Vlad", "Zheltov", "89123456789"));
    ownerRepository.save(new Owner(3, "Roma", "Chernyak", "89465827564"));
    ownerRepository.save(new Owner(4, "Nikita", "Sryvkov", "89957867511"));
    ownerRepository.save(new Owner(5, "Ksusha", "Gruzdeva", "89539573645"));


    ownerRepository.getById(5).get().addAnimal(animalRepository.getById(1).get());
    ownerRepository.getById(5).get().addAnimal(animalRepository.getById(2).get());
    ownerRepository.getById(1).get().addAnimal(animalRepository.getById(3).get());
    ownerRepository.getById(2).get().addAnimal(animalRepository.getById(2).get());
    ownerRepository.getById(3).get().addAnimal(animalRepository.getById(4).get());
    ownerRepository.getById(4).get().addAnimal(animalRepository.getById(5).get());
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
