package General_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;
import servicePackage.StateController;
import servicePackage.WeatherController;

public class tectClass_1 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 1 started ****\n");
		weatherInputs.setRainDesnsity(5.5f);
		weatherInputs.setWindSpeed(15);
		weatherInputs.setWindDirection(100);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(70);
		userInputs.setSetDistance(20);
		leadingVehicle.setLv_present(false);
//		leadingVehicle.setLv_distance();
//		leadingVehicle.setLv_speed(15);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Accelrating", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 1 ended ****\n\n");
	}
}
