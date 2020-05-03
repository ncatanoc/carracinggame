package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.Pair;

public class SET_FINISH_LINETest {
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
	public void test_set_finish_line_01() {
		Integer Car = 11;
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
		//
		Integer Finish = 11;
		Integer Lane = 12; // 
		Integer Left = 1; // 
		Integer Right = 5; // 
		//Integer F = 1; 
		
		ADD_LANE al = new ADD_LANE(machine);

		al.run_ADD_LANE(  Finish,  Lane, Left, Right, F);
		assertTrue(machine.get_lanes().has(Lane));
		assertTrue(machine.get_finish_line().has(new Pair<Integer,Integer>(Lane,Finish)));
		assertTrue(machine.get_left_border().has(new Pair<Integer,Integer>(Lane,Left)));
		assertTrue(machine.get_right_border().has(new Pair<Integer,Integer>(Lane,Right)));
		assertTrue(machine.get_friction().has(new Pair<Integer,Integer>(Lane,F)));
		//
		SET_FINISH_LINE sfl = new SET_FINISH_LINE(machine);
		sfl.run_SET_FINISH_LINE(F, Lane);
		assertTrue(machine.get_finish_line().elementImage(Lane).choose() == F);
	}

}
