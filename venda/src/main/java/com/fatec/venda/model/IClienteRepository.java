package com.fatec.venda.model;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	@Transactional
    void deleteByCpf(String cpf);
	Cliente getByCpf(String cpf);
}