package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SET_VELTest {
	static ref2_scoring machine;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		machine = new ref2_scoring();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_set_vel_01() {
		Integer Car = 1;
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
		
		Integer MAX = 100;
		SET_MAXVEL smv = new SET_MAXVEL(machine);
		smv.run_SET_MAXVEL(Car, MAX);
		assertTrue(machine.get_maxvel().elementImage(Car).choose() == MAX);
		
		Integer V = 55;
		SET_VEL sv = new SET_VEL(machine);
		sv.run_SET_VEL(Car, V);

		Integer newV = machine.get_vel().apply(Car);
		assertTrue(V==newV);
	}

}
