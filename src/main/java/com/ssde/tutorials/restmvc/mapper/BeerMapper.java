package com.ssde.tutorials.restmvc.mapper;

import com.ssde.tutorials.restmvc.entities.Beer;
import com.ssde.tutorials.restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * Created by jra, SSDE, Inc
 * on Tue 1/9/24 at 7:22 PM. rest-mvc
 */
@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
