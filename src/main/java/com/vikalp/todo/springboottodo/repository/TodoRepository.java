package com.vikalp.todo.springboottodo.repository;

import com.vikalp.todo.springboottodo.domain.Todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
}
