package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Ordenes;


public interface IRepositoryOrdenes extends JpaRepository<Ordenes, Long> {

}
