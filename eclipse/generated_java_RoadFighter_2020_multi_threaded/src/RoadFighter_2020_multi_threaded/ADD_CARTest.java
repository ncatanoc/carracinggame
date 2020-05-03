package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.BSet;

public class ADD_CARTest {
	static ref2_scoring machine;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		machine = new ref2_scoring();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test_add_car_01() {
		Integer Car = 11;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		Integer X = 0; // car's position, x-coordinate
		Integer Y = 0; // car's position, y-coordinate
		Integer F = 1; // not used
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);		
		int s1 = machine.get_cars().int_size();

		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		int s2 = machine.get_cars().int_size();
		
		assertTrue(machine.get_cars().has(Car));
		assertTrue(s2 == s1+1);
	}
	
	@Test
	public void test_add_car_02() {
		Integer Car = 5;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		Integer X = 0; // car's position, x-coordinate
		Integer Y = 0; // car's position, y-coordinate
		Integer F = 1; // not used
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		assertTrue(machine.get_cars().has(Car));
		
		int s1 = machine.get_cars().int_size();
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);		
		int s2 = machine.get_cars().int_size();
		assertTrue(s1==s2);
	}
	

}
