package com.hemebiotech.analytics;

/**
 * @author HousM
 */
public class Launcher {

	public static void main(String args[]) throws Exception {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.launch_pg("Project02Eclipse/symptoms.txt");

	}
}
