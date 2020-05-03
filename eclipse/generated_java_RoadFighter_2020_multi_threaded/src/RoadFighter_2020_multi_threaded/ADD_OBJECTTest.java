package RoadFighter_2020_multi_threaded;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class ADD_OBJECTTest {
	
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
	public void test_add_object_01() {
		ADD_OBJECT ao = new ADD_OBJECT(machine);
		
		Integer Desc = 1;
		Integer H = 3;
		Integer W = 6;
		Integer X = 10;
		Integer Y = 20;
		Integer Obj = 11;
		
		ao.run_ADD_OBJECT(Desc, H, Obj, W, X, Y);
		assertTrue(machine.get_objects().has(Obj));
		assertTrue(machine.get_obj_desc().has(new Pair<Integer,Integer>(Obj,Desc)));
		assertTrue(machine.get_height().has(new Pair<Integer,Integer>(Obj,H)));
		assertTrue(machine.get_posX().has(new Pair<Integer,Integer>(Obj,X)));
		assertTrue(machine.get_posY().has(new Pair<Integer,Integer>(Obj,Y)));
	}
	
	@Test
	public void test_add_object_02() {
		ADD_OBJECT ao = new ADD_OBJECT(machine);
		
		Integer Desc = 5;
		Integer H = 3;
		Integer W = 6;
		Integer X = 10;
		Integer Y = 20;
		Integer Obj = 6;

		ao.run_ADD_OBJECT(Desc, H, Obj, W, X, Y);
		int s1 = machine.get_objects().int_size();
		ao.run_ADD_OBJECT(Desc, H, Obj, W, X, Y);
		int s2 = machine.get_objects().int_size();
	
		assertTrue(s1==s2);
	}

}
