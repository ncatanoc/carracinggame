package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UPDATE_POSTest {
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
	public void set_update_pos_01() {
		Integer Car = 11;
		Integer Desc = 0; // description
		Integer H = 1; // car's height
		Integer W = 1; // car's width
		int X = 0; // car's position, x-coordinate
		int Y = 0; // car's position, y-coordinate
		Integer F = 1; // not used
		Integer M = 1; // car's maximum velocity
		
		ADD_CAR ac = new ADD_CAR(machine);
		ac.run_ADD_CAR(Car, Desc, H, W, X, Y, F, M);
		
		SET_POS sp = new SET_POS(machine);
		sp.run_SET_POS(Car, X+10, Y+20);
		assertTrue(machine.get_posX().apply(Car) == 10);
		assertTrue(machine.get_posY().apply(Car) == 20);
		//
		UPDATE_POS up = new UPDATE_POS(machine);
		Integer Elapsed = 666;
		up.run_UPDATE_POS(Elapsed, Car);
		int newX = machine.get_posX().apply(Car);
		int newY = machine.get_posY().apply(Car);
		
		assertTrue(newX > X);
		assertTrue(newY > Y);
	}

}
