package com.recept.team.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerService<T> {
    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getById(int id);

    ResponseEntity<T> add(T entity);

    ResponseEntity<T> update(T entity);

    ResponseEntity delete(int id);
}
