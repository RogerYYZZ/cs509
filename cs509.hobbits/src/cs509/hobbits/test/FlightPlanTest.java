package cs509.hobbits.test;

import static org.junit.Assert.*;
import static org.junit.Test.*;
import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.TestCase;
import cs509.hobbits.search.Airplane;
import cs509.hobbits.search.Airport;
import cs509.hobbits.search.Flight;
import cs509.hobbits.search.FlightPlan;
import cs509.hobbits.search.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class FlightPlanTest extends TestCase {
	private FlightPlan flightPlan;
	private Flight flight1;
	private Flight flight2;
	private Airport BOS;
	private Airport JFK;
	private Airplane plane1;
	private Airplane plane2;
	private ArrayList<Flight> plan = new ArrayList<Flight>();
	  @Before
	  public void setUp(){
		  flight1 = new Flight();
		  flight2 = new Flight();
		  BOS = new Airport();
		  JFK = new Airport();
		  plane1 = new Airplane();
		  plane2 = new Airplane();
		  BOS.setCodeAndName("BOS", "Logan International");
		  BOS.setLocation(42.365855f, -71.009624f);
		  //BOS.setTimeZone("2015_05_10");
		  JFK.setCodeAndName("JFK","John F. Kennedy International");
		  JFK.setLocation(40.641519f, -73.77816f);
		  //JFK.setTimeZone("2015_05_10");
		  flight1.setAirports(BOS, JFK);
		  flight1.setPlane(plane1);
		  flight1.setPrice("$300.00", "$100.00");
		  flight2.setAirports(JFK, BOS);
		  flight2.setPlane(plane2);
		  flight2.setPrice("$400.00", "$100.00");
		  plane1.setSeats(10, 20);
		  plane2.setSeats(10, 20);
		 
		  flightPlan = new FlightPlan(flight1);
		  flightPlan.addFlight(flight2);
	      plan = flightPlan.getPlan();
	  }
	  @Test
	  public void testgetPlan(){
		
		 assertEquals(flight1,plan.get(0));
		 assertEquals(flight2,plan.get(1));
	  }
	  @Test 
	  public void testgetPrice(){
		  assertEquals(700.00f,flightPlan.getPrice(true),10e-10);
		  assertEquals(200.00f,flightPlan.getPrice(false),10e-10);
	  }
	  @Test
	  public void testgetCurrentEnd(){
		  assertEquals(BOS.getCode(),flightPlan.getCurrentEnd().getCode());
		// System.out.println(flightPlan.getCurrentEnd().getCode());
	  }
	  @Test
	  public void testgetLastFlight(){
		  assertEquals(flight2,flightPlan.getLastFlight());
	  }
	  @Test
	  public void testgetStopOver(){
		  assertEquals(1,flightPlan.getStopOver());
	  }
	  @Test
	  public void testisRoundTrip(){
		  assertEquals(flightPlan.isRoundTrip(),false);
	  }
	  @Test
	  public void testgetDepartPlan(){
		  FlightPlan plan1 = new FlightPlan(flight1);
		  FlightPlan plan2 = new FlightPlan(flight2);
		  plan1.buildReturnPlan(plan1, plan2);
		  assertEquals(plan1,plan1.getDepartPlan());
	  }
	  @Test
	  public void testgetReturnPlan(){
		  FlightPlan plan1 = new FlightPlan(flight1);
		  FlightPlan plan2 = new FlightPlan(flight2);
		  plan2.buildReturnPlan(plan1, plan2);
		  assertEquals(plan2,plan1.getDepartPlan());
	  }
}
