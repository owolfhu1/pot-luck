package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PotRepository extends CrudRepository<PotItem, Integer> {
}
