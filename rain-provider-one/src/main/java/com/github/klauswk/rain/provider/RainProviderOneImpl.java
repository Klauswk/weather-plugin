package com.github.klauswk.rain.provider;

import com.github.klauswk.weather.domain.Rain;
import com.github.klauswk.weather.provider.RainProvider;

public class RainProviderOneImpl implements RainProvider {
	
	@Override
	public Rain isRainingIn(String city) {
		Rain rain = new Rain();
		rain.setIsRaining(true);
		return rain;
	}
}
