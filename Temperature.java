

public class Temperature implements Comparable<Temperature> {
/** Enumerator for different temperature units */


	public static enum Units { FAHRENHEIT, CELCIUS, KELVIN }
/**
* Create a new {@code Temperature} with given attributes
* @param value numerical value of {@code Temperature}
* @param units {@code Units} of {@code Temperature}
*/
	private double realValue;
	private Temperature.Units realUnit;
public Temperature (double value, Temperature.Units units) {
// ...
	realValue = value;
	realUnit = units;
}
/**
* Get the value of the {@code Temperature}
* @return numerical value of the {@code Temperature} in the current {@code Units}
*/
public double getValue() {
// ...
	return realValue;
}
/**
* Get the current {@code Units} of the {@code Temperature}
* @return current {@code Units} of {@code Temperature}
*/
public Units getUnits() {
// ...
	return realUnit;
	
}
/**
* Change the current {@code Units} of the {@code Temperature}.
* Changing the {@code Units} also changes the numerical value
* in a consistent manner.
* @param units the new {@code Units}
ECSE 321: Introduction to Software Engineering Fall 2012 (Aditya Mahajan)
Page 2 of 3 September 5, 2012
*/
public void changeUnits(Units units) {
// ...
	String c = "CELCIUS";
	String f = "FAHRENHEIT";
	String k = "KELVIN";
	double tempInC ;
	if (units.equals(realUnit) )
	return;
	// since CELCIUS is present in both equations lets use it as the reference unit and convert everything to celcius
	if (realUnit.toString().equals(c))
	{tempInC = realValue ;
	
	}
	else if (realUnit.toString().equals(f))
	{tempInC = (realValue-32)*5/9;
	
	}
	else 
	{
		tempInC= realValue-273.15;
	}
	
	// now convert from celcius to the desired unit
	
	if (units.toString().equals(c))
		{realValue= tempInC ;
		realUnit = units;
		return;
		}
	else if (units.toString().equals(f))
	    {realValue= tempInC*9/5+32;
	    realUnit = units;
	    return;
	    }
	else if (units.toString().equals(k))
        {realValue = tempInC+273.15;
        realUnit = units;
        return;
        }
	
	
	
}
/**
* Convert the {@code Temperature} to {@code String}. The output is
* as follows
* <pre><code>
* Temperature temperature = new Temperature(0, Units.CELCIUS);
* System.out.println(temperature.toString()); // prints "0 °C"
* temperature.changeUnits(Units.FAHRENHEIT);
* System.out.println(temperature.toString()); // prints "32 °F"
* temperature.changeUnits(Units.KELVIN);
* System.out.println(temperature.toString()); // prints "273.15 K"
* </code></pre>
*/
public String toString() {

	String stringSymbol;
	String stringRepresentation;
	
	if(realUnit.toString().matches("CELCIUS"))
		stringSymbol = "°C";
	else if(realUnit.toString().matches("FAHRENHEIT"))
		stringSymbol = "°F";
	else 
		stringSymbol = "K";
	stringRepresentation = realValue + " " + stringSymbol;
	return stringRepresentation;
	
}
/**
* In order to implement {@code Comparable}, we need to override
* the {@code compareTo} method.
* @param temperature The {@code Temperature} to compare against
* @return -1 if current object is less than {@code temperature}
* 0 if both are equal
* 1 if current object is greater than {@code temperature}
*/
@Override
public int compareTo (Temperature temperature) {
// ...
	Temperature.Units tempUnit = temperature.getUnits();
	if (realUnit.equals(temperature.getUnits()))
	{}
	else 
	temperature.changeUnits(realUnit);

	if(Math.abs(realValue-temperature.getValue()) <= 0.00001 ) {
	temperature.changeUnits(tempUnit);// rechange the unit this way the method does not affect the object
	 return 0;
	}// 0.01 represents the threshold of equality
	else if (realValue < temperature.getValue()) {
	temperature.changeUnits(tempUnit);
	return -1;
	}
	else if (realValue > temperature.getValue()){
	temperature.changeUnits(tempUnit);
	return 1;
	}
	
	else 
		return 100; // to check if none of the case is respected which is not possible because of the enum so it is just for the program to run
	
}
/**
* Indicates whether some object is "equal" to this one.
* To maintain consistency, whenever a class overrdes
* {@code compareTo}, it must override {@code equals} so
* that
* <pre>
* <code>o1.compareTo(o2) == 0</code> implies <code>o1.equals(o2) == true</code>
* </pre>
* See the API documentation of {@code Object} class for more details.
*/
@Override
public boolean equals(Object o) {
// ...
	if (o == null ){

		return false;
	}
		
	Temperature.Units tempRealUnit = realUnit ;// temporary variable to keep the object unchanged after the method is called 
	Temperature.Units tempObjectUnit = ((Temperature) o).getUnits() ;
	    
	    changeUnits(Temperature.Units.CELCIUS);
		((Temperature) o).changeUnits(Temperature.Units.CELCIUS);
		
		

	 if (Math.abs(((Temperature) o).getValue()-realValue)<=0.00001  && ((Temperature) o).getUnits()==realUnit) 
		{   
		    changeUnits(tempRealUnit);// reset the actual unit for the 2 objects
			((Temperature) o).changeUnits(tempObjectUnit);
			return true;
		}
		else {
		    changeUnits(tempRealUnit);
			((Temperature) o).changeUnits(tempObjectUnit);
		    return false;
		}
	
}
/**
* Return a hash code of the object. To maintain consistency,
* whenever a class overrides {@code equals} it mush also override
* {@code hashCode} in such a manner that
* <pre>
* <code>o1.equals(o2) == true</code> implies <code>o1.hashCode() == o2.hashCode()</code>
* </pre>
* See the API documentation of {@code Object} class for more details.
*/

public int hashCode() {
// ...
int hash = 7 ; // arbitrary number to define the hash function and give each temperature value a specific int
hash = hash * 17 + (int)(realValue*100);
// again 17 is an arbitrary variable and i multiplied by 100 to transform from double to int so the casting is only necessary for the programm to work
return hash;
	
}
}


