package com.co.devsu.cuentabancaria.service.imp;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import com.co.devsu.cuentabancaria.mapper.MovimientosMapper;
import com.co.devsu.cuentabancaria.model.Cuenta;
import com.co.devsu.cuentabancaria.model.Movimientos;
import com.co.devsu.cuentabancaria.repository.CuentaRepository;
import com.co.devsu.cuentabancaria.repository.MovimientosRepository;
import com.co.devsu.cuentabancaria.service.MovimientosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovimientosServiceImp implements MovimientosService {

    private final MovimientosMapper movimientosMapper;
    MovimientosRepository movimientosRepository;
    CuentaRepository cuentaRepository;

    @Override
    public List<MovimientosDto> getMovimientos(int idCuenta) {
        return movimientosMapper
                .toListDto(movimientosRepository.getMovimientosByCuenta(idCuenta));
    }
    @Override
    public List<MovimientosDto> getMovimientosByFechas(int idCuenta, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        return movimientosMapper
                .toListDto(movimientosRepository.getMovimientosByFechas(idCuenta, fechaIni, fechaFin));
    }

    @Override
    public MovimientosDto deleteMovimientos(int idMovimiento) throws Exception {
        Optional<Movimientos> movimientos = movimientosRepository.findById(idMovimiento);
        if (movimientos.isPresent()){
            movimientosRepository.delete(movimientos.get());
            return movimientosMapper.toDto(movimientos.get());
        }
        throw new Exception("No existe movimiento para eliminar");
    }

    @Override
    public MovimientosDto updateMovimientos(MovimientosDto movimiento) throws Exception {

        if (movimientosRepository.existsById(movimiento.getId())){
            movimientosRepository.save(movimientosMapper.toModel(movimiento));
            return movimiento;
        }
        throw new Exception("No existe movimiento para actualizar");
    }

    @Override
    public MovimientosDto editMovimientos(MovimientosDto movimiento) throws Exception {
        if (movimientosRepository.existsById(movimiento.getId())){
            movimientosRepository.save(movimientosMapper.toModel(movimiento));
            return movimiento;
        }
        throw new Exception("No existe movimiento para editar");
    }

    @Override
    public MovimientosDto insertMovimientos(CreateMovimientoRequest createMovimientoRequest) throws Exception {
        List<MovimientosDto> movimientosDtoList = getMovimientos(createMovimientoRequest.getIdCuenta());
        if (movimientosDtoList.isEmpty()){
            Cuenta cuenta = cuentaRepository.findById(createMovimientoRequest.getIdCuenta()).orElseThrow();
            createMovimientoRequest.setSaldo(cuenta.getSaldoIncial() + createMovimientoRequest.getSaldo());
        }else {
            createMovimientoRequest.setSaldo(movimientosDtoList.get(0).getSaldo() + createMovimientoRequest.getSaldo());
        }

        if (createMovimientoRequest.getSaldo() < 0){
            throw new Exception("Saldo no disponible");
        }

        createMovimientoRequest.setFecha(LocalDateTime.now());
        Movimientos movimientos = movimientosRepository.save(movimientosMapper.toModel(createMovimientoRequest));

        return movimientosMapper.toDto(movimientos);
    }
}


