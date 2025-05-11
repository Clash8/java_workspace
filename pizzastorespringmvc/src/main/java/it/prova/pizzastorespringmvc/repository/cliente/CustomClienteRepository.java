package it.prova.pizzastorespringmvc.repository.cliente;

import it.prova.pizzastorespringmvc.model.Cliente;

import java.util.List;

public interface CustomClienteRepository {
    List<Cliente> findByExample(Cliente example);
}
