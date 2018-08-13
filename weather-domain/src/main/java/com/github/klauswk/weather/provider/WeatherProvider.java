package com.github.klauswk.weather.provider;

import com.github.klauswk.weather.domain.Weather;

public interface WeatherProvider {
	
	public Weather getCurrentWeather(Long id);
	
}
