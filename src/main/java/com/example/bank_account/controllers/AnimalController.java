package com.example.bank_account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bank_account.model.Animal;
import com.example.bank_account.service.AnimalService;
import com.example.bank_account.viewModel.BaseViewModel;
import com.example.bank_account.viewModel.GetAllAnimals;
import com.example.bank_account.viewModel.GetByIdAnimal;

@Controller
@RequestMapping("/animals")
public class AnimalController {
  private AnimalService animalService;
  @GetMapping("")
  public String findAll(Model model) {
    List<Animal> owners = animalService.getAll();

    var getAllOwnerViewModel = new GetAllAnimals(
      "Список животных",
      owners
    );

    model.addAttribute("model", getAllOwnerViewModel);

    return "pages/all-animals";
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable int id, Model model) {
    Animal animal = animalService.getById(id);

    var getAnimalByIdViewModel = new GetByIdAnimal(
        "Животное " + animal.getName(),
        animal
    );

    model.addAttribute("model", getAnimalByIdViewModel);

    return "pages/find-one-animal";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    var animalCreateViewModel = new BaseViewModel("Создание животного");

    model.addAttribute("model", animalCreateViewModel);
    model.addAttribute("form", new Animal(0, "", ""));

    return "pages/create-animal";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute("form") Animal form, Model model){
    animalService.create(form);
    return "redirect:/animals/" + form.getId();
  }

  @Autowired
  public void setAnimalRepository(AnimalService animalService) {
    this.animalService = animalService;
  }
}
