package com.ssde.tutorials.restmvc.controller;

import com.ssde.tutorials.restmvc.model.BeerDTO;
import com.ssde.tutorials.restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Fri 12/29/23 at 4:28 PM. rest-mvc
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    public static final String BEER_FULL_PATH = "/api/v1/beer";
    public static final String BEER_PATH = "";
    public static final String BEER_PATH_ID = "/{beerId}"; //BEER_PATH + "/{beerId}";
    public static final String BEER_FULL_PATH_ID = BEER_FULL_PATH + BEER_PATH_ID;

    private final BeerService beerService;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity<?> updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity<?> deleteById(@PathVariable("beerId") UUID beerId){

        beerService.deleteById(beerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<?> updateById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

        beerService.updateBeerById(beerId, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<?> handlePost(@RequestBody BeerDTO beer){

        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers(){
        return beerService.listBeers();
    }


    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }
}
