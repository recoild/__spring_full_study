package com.ramramv.estate_search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramramv.estate_search.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
