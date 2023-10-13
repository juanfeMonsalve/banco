package com.co.devsu.cuentabancaria.mapper;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import com.co.devsu.cuentabancaria.model.Movimientos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientosMapper {
    MovimientosMapper INSTANCE = Mappers.getMapper(MovimientosMapper.class);

    MovimientosDto toDto(Movimientos movimientos);
    Movimientos toModel(MovimientosDto movimientosDto);
    Movimientos toModel(CreateMovimientoRequest movimientosDto);

    List<MovimientosDto> toListDto(List<Movimientos> movimientosList);

}

