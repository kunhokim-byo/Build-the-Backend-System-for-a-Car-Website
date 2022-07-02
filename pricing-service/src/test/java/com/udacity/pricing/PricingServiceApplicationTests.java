package com.udacity.pricing;

import com.netflix.discovery.converters.Auto;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {
	@MockBean
	PricingService pricingService;

//	@Autowired
//	private JacksonTester<Price> json;

//	public PricingServiceApplicationTests(PricingService pricingService) {
//		this.pricingService = pricingService;
//	}

	@Autowired
	MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Test
	//Solve this issue by https://stackoverflow.com/questions/39267966/unit-testing-for-spring-mvc-controller-with-integer-value-as-requestparam
	public void findPriceByVehicleId() throws Exception{
		mvc.perform(get("/services/price?vehicleId=1"))
				.andExpect(status().isOk());

	}



}