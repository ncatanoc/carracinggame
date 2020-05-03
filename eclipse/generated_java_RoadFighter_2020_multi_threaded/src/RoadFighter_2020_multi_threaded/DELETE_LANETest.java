package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.Pair;

public class DELETE_LANETest {
	ref2_scoring machine;


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
	public void test_delete_lane_01() {
		Integer Finish = 11;
		Integer Lane = 12; // 
		Integer Left = 1; // 
		Integer Right = 5; // 
		Integer F = 1; // 
		
		ADD_LANE al = new ADD_LANE(machine);

		al.run_ADD_LANE(  Finish,  Lane, Left, Right, F);
		assertTrue(machine.get_lanes().has(Lane));
		assertTrue(machine.get_finish_line().has(new Pair<Integer,Integer>(Lane,Finish)));
		assertTrue(machine.get_left_border().has(new Pair<Integer,Integer>(Lane,Left)));
		assertTrue(machine.get_right_border().has(new Pair<Integer,Integer>(Lane,Right)));
		assertTrue(machine.get_friction().has(new Pair<Integer,Integer>(Lane,F)));
		
		DELETE_LANE dl = new DELETE_LANE(machine);
		dl.run_DELETE_LANE(Lane);
		assertFalse(machine.get_lanes().has(Lane));				
	}

}
