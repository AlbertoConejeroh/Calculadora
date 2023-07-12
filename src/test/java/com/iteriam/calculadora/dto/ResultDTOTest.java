package com.iteriam.calculadora.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.iteriam.calculadora.exception.CustomException;

public class ResultDTOTest {

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculaServiceSumaTest() throws CustomException {

		ResultDTO resultDTO = new ResultDTO(new BigDecimal("1"));
		assertTrue(resultDTO.getResult().compareTo(new BigDecimal("1")) == 0);
		resultDTO.setResult(new BigDecimal("2"));
		assertTrue(resultDTO.getResult().compareTo(new BigDecimal("2")) == 0);
		resultDTO.toString();
		resultDTO.equals(null);
		resultDTO.equals(resultDTO);
		ResultDTO resultDTOTwo = new ResultDTO(new BigDecimal("2"));
		resultDTO.equals(resultDTOTwo);
	}
}
