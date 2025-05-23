package com.example.bank_account.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bank_account.viewModel.BaseViewModel;

@Controller
@RequestMapping("/")
public class HealthCheckController {
  @GetMapping("/")
  public String findById(Model model) {
    var viewModel = new BaseViewModel(
        "Проверка работы"
    );

    model.addAttribute("model", viewModel);

    return "pages/check";
  }
}
