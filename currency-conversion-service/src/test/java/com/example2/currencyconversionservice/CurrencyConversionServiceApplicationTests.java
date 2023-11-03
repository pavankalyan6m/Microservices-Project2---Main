package com.example2.currencyconversionservice;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import org.junit.Assert.*;

@SpringBootTest
class CurrencyConversionServiceApplicationTests {

	@Test
	public void calculateCurrencyConversionTest() {
		CurrencyConversionController cc = new CurrencyConversionController();
		CurrencyConversion response = cc.calculateCurrencyConversion("USD","INR", BigDecimal.valueOf(10));

		CurrencyConversion cc_expected = new CurrencyConversion();

		cc_expected.setId(1001L);
		cc_expected.setFrom("USD");
		cc_expected.setTo("INR");
		cc_expected.setConversionMultiple(BigDecimal.valueOf(80));
		cc_expected.setTotalCalculatedAmount(BigDecimal.valueOf(800));
		cc_expected.setQuantity(BigDecimal.valueOf(10));
		cc_expected.setEnvironment("8000 rest template");// Set the expected amount
		// Set other expected properties as needed

		// Now, you can compare the actual and expected objects
		Assert.assertNotNull(response);
		Assert.assertEquals(cc_expected.getConversionMultiple().stripTrailingZeros(), response.getConversionMultiple().stripTrailingZeros());
		Assert.assertEquals(cc_expected.getTotalCalculatedAmount().stripTrailingZeros(), response.getTotalCalculatedAmount().stripTrailingZeros());

	}

	@Test
	public void calculateCurrencyConversionFeign() {
		CurrencyConversionController cc = new CurrencyConversionController();
		CurrencyConversion response = cc.calculateCurrencyConversion("USD","INR", BigDecimal.valueOf(10));

		CurrencyConversion cc_expected = new CurrencyConversion();

		cc_expected.setId(1001L);
		cc_expected.setFrom("USD");
		cc_expected.setTo("INR");
		cc_expected.setConversionMultiple(BigDecimal.valueOf(80));
		cc_expected.setTotalCalculatedAmount(BigDecimal.valueOf(800));
		cc_expected.setQuantity(BigDecimal.valueOf(10));
		cc_expected.setEnvironment("8000 feign");// Set the expected amount
		// Set other expected properties as needed

		// Now, you can compare the actual and expected objects
		Assert.assertNotNull(response);
		Assert.assertEquals(cc_expected.getConversionMultiple().stripTrailingZeros(), response.getConversionMultiple().stripTrailingZeros());
		Assert.assertEquals(cc_expected.getTotalCalculatedAmount().stripTrailingZeros(), response.getTotalCalculatedAmount().stripTrailingZeros());

	}
}
