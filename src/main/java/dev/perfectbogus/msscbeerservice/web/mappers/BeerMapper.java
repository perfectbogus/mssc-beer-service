package dev.perfectbogus.msscbeerservice.web.mappers;

import dev.perfectbogus.msscbeerservice.domain.Beer;
import dev.perfectbogus.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);

}
