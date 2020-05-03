package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DELETE_CARTest {
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
	public void delete_car_01() {
		Integer Car = 11;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		Integer X = 5; // car's position, x-coordinate
		Integer Y = 5; // car's position, y-coordinate
		Integer F = 1; // not used to create car but to create the lane
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);	
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		
		assertTrue(machine.get_cars().has(Car));
		
		DELETE_CAR dc = new DELETE_CAR(machine);
		dc.run_DELETE_CAR(Car);
		assertFalse(machine.get_cars().has(Car));
	}

	@Test
	public void delete_car_02() {
		Integer Car = 11;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		Integer X = 5; // car's position, x-coordinate
		Integer Y = 5; // car's position, y-coordinate
		Integer F = 1; // not used to create car but to create the lane
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);	
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		
		assertTrue(machine.get_cars().has(Car));
		
		DELETE_CAR dc = new DELETE_CAR(machine);
		dc.run_DELETE_CAR(Car);
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		assertTrue(machine.get_cars().has(Car));
	}

	@Test
	public void delete_car_3() {
		Integer Car1 = 11, Car2 = 12, Car3 = 13;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		Integer X = 5; // car's position, x-coordinate
		Integer Y = 5; // car's position, y-coordinate
		Integer F = 1; // not used to create car but to create the lane
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);	
		ac.run_ADD_CAR(Car1, Desc, H, W, X, Y, F, M);
		ac.run_ADD_CAR(Car2, Desc, H, W, X, Y, F, M);
		ac.run_ADD_CAR(Car3, Desc, H, W, X, Y, F, M);
		
		assertTrue(machine.get_cars().has(Car1));
		assertTrue(machine.get_cars().has(Car2));
		assertTrue(machine.get_cars().has(Car3));

		
		DELETE_CAR dc = new DELETE_CAR(machine);
		dc.run_DELETE_CAR(Car1);
		dc.run_DELETE_CAR(Car2);
		dc.run_DELETE_CAR(Car3);
		assertFalse(machine.get_cars().has(Car1));
		assertFalse(machine.get_cars().has(Car2));
		assertFalse(machine.get_cars().has(Car3));
	}

}
