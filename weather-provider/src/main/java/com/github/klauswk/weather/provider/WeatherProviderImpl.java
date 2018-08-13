package com.github.klauswk.weather.provider;

import com.github.klauswk.weather.domain.Weather;

public class WeatherProviderImpl implements WeatherProvider {

	public Weather getCurrentWeather(Long id) {
		Weather weather = new Weather();
		weather.setWeather("SUNNY DAY MAN");
		return weather;
	}
}
