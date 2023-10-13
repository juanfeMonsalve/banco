package com.co.devsu.cuentabancaria.repository;

import com.co.devsu.cuentabancaria.model.Cuenta;
import com.co.devsu.cuentabancaria.model.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {
    @Query(nativeQuery = true,
            value = "select * from cuenta where idcliente = ?1 ")
    List<Cuenta> getCuentasByIdentificacion(int idCliente);

}
