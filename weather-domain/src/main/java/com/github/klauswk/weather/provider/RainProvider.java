package com.github.klauswk.weather.provider;

import com.github.klauswk.weather.domain.Rain;

public interface RainProvider {

	public Rain isRainingIn(String city);
	
}
