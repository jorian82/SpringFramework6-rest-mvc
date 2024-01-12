package com.ssde.tutorials.restmvc.service;

import com.ssde.tutorials.restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Fri 12/29/23 at 4:18 PM. rest-mvc
 */
public interface BeerService {

    public Optional<BeerDTO> getBeerById(UUID id);

    List<BeerDTO> listBeers();

    void patchBeerById(UUID beerId, BeerDTO beer);

    void deleteById(UUID beerId);

    void updateBeerById(UUID beerId, BeerDTO beer);

    BeerDTO saveNewBeer(BeerDTO beer);
}
