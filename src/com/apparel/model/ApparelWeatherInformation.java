package com.apparel.model;

/**
 * The model class containing the current weather information and apparel worn by the person. 
 * @author Shiva
 *
 */
public class ApparelWeatherInformation {
	private Weather currWeather;
	private boolean[] bArrApparelWorn;

	public ApparelWeatherInformation(Weather weather, int totalApparelCount) {
		this.setCurrWeather(weather);
		bArrApparelWorn = new boolean[totalApparelCount];
	}

	public Weather getCurrWeather() {
		return currWeather;
	}

	public void setCurrWeather(Weather currWeather) {
		this.currWeather = currWeather;
	}

	public boolean getApparelWorn(int index) {
		return bArrApparelWorn[index];
	}
	
	public boolean[] getApparelWorn() {
		return bArrApparelWorn;
	}

	public void setApparelWorn(int index, boolean result) {
		if(index < bArrApparelWorn.length)
			this.bArrApparelWorn[index] = result;
	}
}
