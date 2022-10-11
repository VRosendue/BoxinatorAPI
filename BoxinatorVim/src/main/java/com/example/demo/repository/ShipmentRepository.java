package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Shipments;
import com.example.demo.models.Users;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Integer> {

}
