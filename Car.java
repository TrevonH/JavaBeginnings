/*
 * Trevon Herman
 * Fuel Efficiency Program 1.0
 * 
 */

public class Car
{
	double fuel;
	double gasInTank;
	double gasAmount;
    double getGasLevel;
    double fuelEfficiency;
    double gallons;
    double miles;
    double drive;
    
	public Car(double fuelEfficency)
	{
		
	}
		public void addGas(double gallons) // Adding fuel to the car
		{
			fuel = fuel + gallons;
		}

		public void drive(double miles) // Calculates miles driven and updates fuel level
		{
		    drive = drive + miles;
		    fuel = fuel - (miles / fuelEfficiency);
		}

		public void fuelEfficency(double efficency) // Calculates the fuel efficiency in the car after its been driven
		{
			efficency = miles / gallons;
		}
		public double getGasInTank() // Returns the value of gas in the tank
		{
			return fuel;
		}

		public static void main (String [] args)
		{
			Car myHybrid = new Car(20); //50 miles per gallon
			myHybrid.addGas(20); //Tank 20 gallons
			myHybrid.drive(100); //Drive 100 miles
			System.out.println(myHybrid.getGasInTank()); //Print fuel remaining
		}
	}

/* 
My return value is showing -Infinity, im not sure whats causing it to show that value,
I've looked in the book and I cant
figure out what I'm doing wrong with my code
*/
