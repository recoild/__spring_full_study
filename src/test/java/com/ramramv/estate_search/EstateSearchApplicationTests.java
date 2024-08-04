package com.ramramv.estate_search;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ramramv.estate_search.service.AddressService;

@SpringBootTest
@ActiveProfiles("test")
class EstateSearchApplicationTests {
	@Autowired
	private AddressService addressService;

	@Test
	public void createAddressTest() {
		addressService.createAddress();
	}
}
