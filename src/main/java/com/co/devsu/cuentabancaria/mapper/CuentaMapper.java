package com.co.devsu.cuentabancaria.mapper;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.CuentaDto;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import com.co.devsu.cuentabancaria.model.Cuenta;
import com.co.devsu.cuentabancaria.model.Movimientos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

    CuentaDto toDto(Cuenta cuenta);
    List<CuentaDto> toDtoList(List<Cuenta> cuentaList);
    Cuenta toModel(CuentaDto cuentaDto);


}

