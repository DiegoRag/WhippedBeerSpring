package com.whipped_beer.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whipped_beer.app.entities.Data;

public interface DataRepository extends JpaRepository<Data, Integer> {

}