package com.ssde.tutorials.restmvc.service;

import com.ssde.tutorials.restmvc.controller.BeerController;
import com.ssde.tutorials.restmvc.model.BeerDTO;
import com.ssde.tutorials.restmvc.repositories.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jra, SSDE, Inc
 * on Wed 1/10/24 at 6:17 PM. rest-mvc
 */
@SpringBootTest
class BeerServiceIT {
    @Autowired
    BeerController beerController;
    @Autowired
    BeerRepository beerRepository;

    @Test
    void TestListBeers() {
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(4);
    }

    @Test
    void testEmptyList(){
        beerRepository.deleteAll();
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }

}