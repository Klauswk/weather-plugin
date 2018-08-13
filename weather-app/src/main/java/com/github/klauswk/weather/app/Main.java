package com.github.klauswk.weather.app;

import java.util.ServiceLoader;

import com.github.klauswk.weather.provider.WeatherProvider;

public class Main {

	public static void main(String[] args) {
		WeatherProvider providedService = null;
		
		ServiceLoader<WeatherProvider> serviceLoader = ServiceLoader.load(WeatherProvider.class);
		
		boolean hasNext = serviceLoader.iterator().hasNext();
		
		if(hasNext){
			providedService = serviceLoader.iterator().next();
		}
		
		if(providedService == null) {
			System.out.println("No service provider found");
		} else {
			System.out.println(providedService.getCurrentWeather(1l).getWeather());
		}
		
	}

}
