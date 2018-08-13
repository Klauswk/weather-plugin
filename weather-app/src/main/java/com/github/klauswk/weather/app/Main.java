package com.github.klauswk.weather.app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import com.github.klauswk.weather.provider.RainProvider;
import com.github.klauswk.weather.provider.WeatherProvider;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		loadServices();

		weatherProviderTest();
		rainProviderTest();
	}

	private static void rainProviderTest() {
		ServiceLoader<RainProvider> serviceLoader = ServiceLoader.load(RainProvider.class);
		
		serviceLoader.forEach(r -> {
			System.out.println("Provider class: " + r.getClass());
			System.out.println(r.isRainingIn("").getIsRaining());
		});
	}

	private static void weatherProviderTest() {
		WeatherProvider providedService = null;

		ServiceLoader<WeatherProvider> serviceLoader = ServiceLoader.load(WeatherProvider.class);

		boolean hasNext = serviceLoader.iterator().hasNext();

		if (hasNext) {
			providedService = serviceLoader.iterator().next();
		}

		if (providedService == null) {
			System.out.println("No service provider found");
		} else {
			System.out.println(providedService.getCurrentWeather(1l).getWeather());
		}
	}

	public static void loadServices() throws MalformedURLException {
		List<URI> jarsList = Arrays.stream(new File("modules/").listFiles()).map(File::toURI)
				.collect(Collectors.toList());

		List<URL> urlList = jarsList.stream().map(t -> {
			try {
				return t.toURL();
			} catch (MalformedURLException e) {
				return null;
			}
		}).collect(Collectors.toList());

		URL[] urls = urlList.toArray(new URL[0]);

		URLClassLoader child = new URLClassLoader(urls, Main.class.getClassLoader());

		Thread.currentThread().setContextClassLoader(child);
	}
}
