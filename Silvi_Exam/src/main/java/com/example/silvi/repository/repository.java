
package com.example.silvi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.silvi.model.book;

@Repository
public interface repository extends CrudRepository<book , Integer> {

}

