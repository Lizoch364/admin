package com.example.bank_account.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.bank_account.model.Owner;

@Repository
public class OwnerRepository {
  private final Map<Integer,Owner> owners = new HashMap<>();

  public Optional<Owner> getById(int id) {
    return Optional.ofNullable(owners.get(id));
  }

  public List<Owner> getAll() {
    return new ArrayList<>(owners.values());
  }

  public void save(Owner owner) {
    owners.put(owner.getId(), owner);
  }

  public void delete(int id) {
    owners.remove(id);
  }
}
