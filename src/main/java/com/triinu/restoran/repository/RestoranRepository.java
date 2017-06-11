package com.triinu.restoran.repository;

import com.triinu.restoran.entity.Restoran;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RestoranRepository extends Repository<Restoran, Long> {
    Restoran findOne(Long id);
    Restoran save(Restoran restoran);
    List<Restoran> findAll();
}
