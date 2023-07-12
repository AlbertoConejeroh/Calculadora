package com.iteriam.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;


/**
 * The Class TracerConfig.
 *
 * @author Alberto Conejero Hernandez
 */
@Configuration
public class TracerConfig {

	/**
	 * Gets the tracer imp.
	 *
	 * @return the tracer imp
	 */
	@Bean
	public TracerImpl getTracerImp() {
		return new TracerImpl();
	}
}
