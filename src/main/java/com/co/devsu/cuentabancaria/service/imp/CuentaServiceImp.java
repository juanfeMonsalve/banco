package com.co.devsu.cuentabancaria.service.imp;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.CuentaDto;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import com.co.devsu.cuentabancaria.mapper.CuentaMapper;
import com.co.devsu.cuentabancaria.mapper.MovimientosMapper;
import com.co.devsu.cuentabancaria.model.Cuenta;
import com.co.devsu.cuentabancaria.model.Movimientos;
import com.co.devsu.cuentabancaria.repository.CuentaRepository;
import com.co.devsu.cuentabancaria.repository.MovimientosRepository;
import com.co.devsu.cuentabancaria.service.CuentaService;
import com.co.devsu.cuentabancaria.service.MovimientosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CuentaServiceImp implements CuentaService {
    private final CuentaMapper cuentaMapper;
    CuentaRepository cuentaRepository;

    @Override
    public CuentaDto getCuenta(int idCuenta) {
        return cuentaMapper.toDto(cuentaRepository.findById(idCuenta).orElse(null));
    }
    @Override
    public List<CuentaDto> getCuentas(int idcliente) {
        return cuentaMapper.toDtoList(cuentaRepository.getCuentasByIdentificacion(idcliente));
    }

    @Override
    public  CuentaDto deleteCuenta(int idCuenta) throws Exception {
        Optional<Cuenta> cuenta = cuentaRepository.findById(idCuenta);
        if (cuenta.isPresent()){
            cuentaRepository.delete(cuenta.get());
            return cuentaMapper.toDto(cuenta.get());
        }
        throw new Exception("No existe cuenta para eliminar");
    }

    @Override
    public CuentaDto updateCuenta(CuentaDto cuentaDto) throws Exception {

        if (cuentaRepository.existsById(cuentaDto.getId())){
            cuentaRepository.save(cuentaMapper.toModel(cuentaDto));
            return cuentaDto;
        }
        throw new Exception("No existe cuenta para actualizar");
    }

    @Override
    public CuentaDto editCuenta(CuentaDto cuentaDto) throws Exception {
        if (cuentaRepository.existsById(cuentaDto.getId())){
            cuentaRepository.save(cuentaMapper.toModel(cuentaDto));
            return cuentaDto;
        }
        throw new Exception("No existe cuenta para editar");
    }

    @Override
    public CuentaDto insertCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = cuentaRepository.save(cuentaMapper.toModel(cuentaDto));
        return cuentaMapper.toDto(cuenta);
    }
}


