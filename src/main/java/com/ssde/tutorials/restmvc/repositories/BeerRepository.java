package com.ssde.tutorials.restmvc.repositories;

import com.ssde.tutorials.restmvc.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Tue 1/9/24 at 6:55 PM. rest-mvc
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
