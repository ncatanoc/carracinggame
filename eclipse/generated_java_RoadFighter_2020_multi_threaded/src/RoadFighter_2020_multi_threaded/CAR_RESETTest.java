package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.BRelation;

public class CAR_RESETTest {
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
	public void test_car_reset_01() {
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

		Integer Finish = 11;
		Integer Lane = 12; // 
		Integer Left = 1; // 
		Integer Right = 5; // 
		//Integer F = 1;
		
		ADD_LANE al = new ADD_LANE(machine);
		al.run_ADD_LANE( Finish,  Lane, Left, Right, F);

		int posx = machine.get_posX().elementImage(Car).choose();
		
		CAR_RESET cr = new CAR_RESET(machine);
		cr.run_CAR_RESET(Car, Lane);
		int newposx = machine.get_posX().elementImage(Car).choose();
		assertTrue(newposx != posx);
	}

}
