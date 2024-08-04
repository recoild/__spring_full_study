package com.ramramv.estate_search.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ramramv.estate_search.models.Address;
import com.ramramv.estate_search.repository.AddressRepository;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAddress() {
        // Create an address
        Address address = Address.builder()
                .addressLine("서울특별시 강남구 역삼동 123-456")
                .latitude(new BigDecimal("37.123456"))
                .longitude(new BigDecimal("127.123456"))
                .build();
        addressRepository.save(address);

    }
}
