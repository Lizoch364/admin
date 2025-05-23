package com.example.bank_account.viewModel;

import java.util.List;

import com.example.bank_account.model.Owner;

public record GetAllOwners (
  String title,
  List<Owner> owners
) {}


