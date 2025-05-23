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

import com.example.bank_account.model.Owner;
import com.example.bank_account.service.OwnerService;
import com.example.bank_account.viewModel.BaseViewModel;
import com.example.bank_account.viewModel.GetAllOwners;
import com.example.bank_account.viewModel.GetByIdOwner;


@Controller
@RequestMapping("/owners")
public class OwnerController {
  private OwnerService ownerService;

  @GetMapping("")
  public String findAll(Model model) {
    List<Owner> owners = ownerService.getAll();

    var getAllOwnerViewModel = new GetAllOwners(
      "Список хозяинов",
      owners
    );

    model.addAttribute("model", getAllOwnerViewModel);

    return "pages/all-owners";
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable int id, Model model) {
    Owner owner = ownerService.getById(id);

    var getOwnerByIdViewModel = new GetByIdOwner(
        "Хозяин " + owner.getName(),
        owner
    );

    model.addAttribute("model", getOwnerByIdViewModel);

    return "pages/find-one-owner";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    var ownerCreateViewModel = new BaseViewModel("Создание хозяина");

    model.addAttribute("model", ownerCreateViewModel);
    model.addAttribute("form", new Owner(0, "", "", ""));

    return "pages/create-owner";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute("form") Owner form, Model model){
    ownerService.create(form);
    return "redirect:/owners/" + form.getId();
  }

  @Autowired
  public void setOwnerService(OwnerService ownerService) {
    this.ownerService = ownerService;
  }
}
