package com.jackhodge.DataViewTool.repository;

import com.jackhodge.DataViewTool.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Spring automatically implements this during runtime


public interface PersonRepository extends CrudRepository<Person, Long> {

    // derived query
    List<Person> findByLastName(String lastName);

    Person findById(long id);
}
