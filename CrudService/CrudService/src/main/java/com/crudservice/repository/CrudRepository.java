package com.crudservice.repository;

import com.crudservice.entity.Crud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Crud,Long> {
}
