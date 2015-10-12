package cs509.hobbits.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import cs509.hobbits.search.Flight;
import cs509.hobbits.search.LocalTime;
import cs509.hobbits.search.Airport;
import cs509.hobbits.search.Airplane;

public class FlightTest {
	Flight flight;
	Airport BOS;
	Airport JFK;
	LocalTime dep_time;
	LocalTime arr_time;
	Airplane plane;
	@Before
	public void setUp() {
		System.out.print("setting up");
		flight = new Flight ();
		BOS = new Airport();
		JFK = new Airport();
		plane = new Airplane();
		BOS.setCodeAndName("BOS", "Logan International");
		BOS.setLocation(42.365855f, -71.009624f);
		//BOS.setTimeZone("2015_05_10");
		JFK.setCodeAndName("JFK","John F. Kennedy International");
		JFK.setLocation(40.641519f, -73.77816f);
		//JFK.setTimeZone("2015_05_10");	
		dep_time = new LocalTime();
		arr_time = new LocalTime();
		dep_time.setTime("2015 May 10 05:04 GMT");
		dep_time.setAirport(BOS);
		flight.setAirports(BOS, JFK);
		plane.setModel("manu1", "model1");
		plane.setSeats(3, 4);
		flight.setPlane(plane);
	}
	

   @Test
	public void testgetCode(){
	   
		assertEquals("BOS",flight.getCode(true));
		assertEquals("JFK",flight.getCode(false));
	}
	@Test
	public void testgetFlightTime(){
		flight.setFlightTime(8);
		assertEquals(8,flight.getFlightTime());
	}
	@Test
	public void testgetPrice(){
		flight.setPrice("%450.30", "$230.20");
		assertEquals(450.30f,flight.getPrice(true),10e-10);
		assertEquals(230.20f,flight.getPrice(false),10e-10);
	}
	@Test
	public void testgetLocalTime(){
		
			
		
        flight.setLocalTime("2015 May 10 05:04 GMT", "2015 May 10 20:44 GMT");
      //  System.out.print(flight.getLocalTime(true));
		assertEquals(dep_time,flight.getLocalTime(true)); 
	}
	@Test
	public void testgetLocalTimeString(){
		 flight.setLocalTime("2015 May 10 05:04 GMT", "2015 May 10 20:44 GMT");
		 assertEquals("10 May 2015 05:04 GMT",flight.getLocalTimeString(true)) ;
	}
	@Test
	public void testgetDateCode(){
         //System.out.println(dep_time.getDateCode()+"timestamp");
		 assertEquals("2015_05_10",dep_time.getDateCode());
	}
	@Test
	public void testgetAirport(){
	     assertEquals(BOS.getCode(),flight.getAirport(true).getCode());
	}
	@Test
	public void testgetSeat(){
		flight.setSeats(1, 0);
		assertEquals(2,flight.getSeat(true));
	}
}