package com.triinu.restoran.repository;

import com.triinu.restoran.entity.RestoRating;
import com.triinu.restoran.entity.Restoran;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by triinuerik on 10/06/2017.
 */
public interface RatingRepository extends Repository<RestoRating, Long> {
    RestoRating save(RestoRating restoRating);
    List<RestoRating> findAll();

    @Query("select r from RestoRating r where r.restoran.id = :restaurant")
    List<RestoRating> findByRestaurantId(@Param("restaurant") Long restaurant);

    Restoran findOne(Long id);


}
