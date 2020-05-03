package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class ADD_OBSTACLETest {
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

	@Test
	public void test_add_obstacle_01() {
		ADD_OBSTACLE ao = new ADD_OBSTACLE(machine);
		
		Integer Desc = 1;
		Integer H = 3;
		Integer W = 6;
		Integer X = 10;
		Integer Y = 20;
		Integer Obs = 11;
		
		ao.run_ADD_OBSTACLE(Desc, H, Obs, W, X, Y);
		assertTrue(machine.get_obstacles().has(Obs));
		assertTrue(machine.get_obj_desc().has(new Pair<Integer,Integer>(Obs,Desc)));
		assertTrue(machine.get_height().has(new Pair<Integer,Integer>(Obs,H)));
		assertTrue(machine.get_posX().has(new Pair<Integer,Integer>(Obs,X)));
		assertTrue(machine.get_posY().has(new Pair<Integer,Integer>(Obs,Y)));		
	}

}
