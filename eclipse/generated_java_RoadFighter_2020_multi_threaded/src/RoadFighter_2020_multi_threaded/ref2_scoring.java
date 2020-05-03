package RoadFighter_2020_multi_threaded;

import eventb_prelude.*;
import Util.*;
//@ model import org.jmlspecs.models.JMLObjectSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ref2_scoring{
	private int n_events = 24;
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;
	private Thread[] events;
	public Lock lock = new ReentrantLock(true);


	/******Set definitions******/
	//@ public static constraint LANES.equals(\old(LANES)); 
	public static final BSet<Integer> LANES = new Enumerated(min_integer,max_integer);

	//@ public static constraint OBJECTS.equals(\old(OBJECTS)); 
	public static final BSet<Integer> OBJECTS = new Enumerated(min_integer,max_integer);


	/******Constant definitions******/
	//@ public static constraint USER_CAR.equals(\old(USER_CAR)); 
	//public static final Integer USER_CAR = Test_ref2_scoring.random_USER_CAR;

	//@ public static constraint USER_LANE.equals(\old(USER_LANE)); 
	//public static final Integer USER_LANE = Test_ref2_scoring.random_USER_LANE;



	/******Axiom definitions******/
	/*@ public static invariant INT.instance.has(USER_LANE); */
	/*@ public static invariant INT.instance.has(USER_CAR); */


	/******Variable definitions******/
	/*@ spec_public */ private BRelation<Integer,Integer> acc;

	/*@ spec_public */ private BRelation<Integer,Boolean> active;

	/*@ spec_public */ private BSet<Integer> cars;

	/*@ spec_public */ private BRelation<Integer,Boolean> collision;

	/*@ spec_public */ private BRelation<Integer,Integer> drift;

	/*@ spec_public */ private BRelation<Integer,Integer> finish_line;

	/*@ spec_public */ private BRelation<Integer,Boolean> finished;

	/*@ spec_public */ private BRelation<Integer,Integer> friction;

	/*@ spec_public */ private BRelation<Integer,Integer> height;

	/*@ spec_public */ private BSet<Integer> lanes;

	/*@ spec_public */ private BRelation<Integer,Integer> left_border;

	/*@ spec_public */ private BRelation<Integer,Integer> maxvel;

	/*@ spec_public */ private BRelation<Integer,Integer> obj_desc;

	/*@ spec_public */ private BSet<Integer> objects;

	/*@ spec_public */ private BSet<Integer> obstacles;

	/*@ spec_public */ private BRelation<Integer,Integer> posX;

	/*@ spec_public */ private BRelation<Integer,Integer> posY;

	/*@ spec_public */ private BRelation<Integer,Integer> right_border;

	/*@ spec_public */ private BRelation<Integer,Integer> score;

	/*@ spec_public */ private BRelation<Integer,Integer> vel;

	/*@ spec_public */ private BRelation<Integer,Integer> width;




	/******Invariant definition******/
	/*@ public invariant
		objects.isSubset(OBJECTS) &&
		obstacles.isSubset(objects) &&
		cars.isSubset(objects) &&
		(cars.intersection(obstacles)).equals(BSet.EMPTY) &&
		lanes.isSubset(LANES) &&
		 finish_line.domain().equals(lanes) && finish_line.range().isSubset(INT.instance) && finish_line.isaFunction() && BRelation.cross(lanes,INT.instance).has(finish_line) &&
		 left_border.domain().equals(lanes) && left_border.range().isSubset(INT.instance) && left_border.isaFunction() && BRelation.cross(lanes,INT.instance).has(left_border) &&
		 right_border.domain().equals(lanes) && right_border.range().isSubset(INT.instance) && right_border.isaFunction() && BRelation.cross(lanes,INT.instance).has(right_border) &&
		 posX.domain().equals(objects) && posX.range().isSubset(INT.instance) && posX.isaFunction() && BRelation.cross(objects,INT.instance).has(posX) &&
		 posY.domain().equals(objects) && posY.range().isSubset(INT.instance) && posY.isaFunction() && BRelation.cross(objects,INT.instance).has(posY) &&
		 width.domain().equals(objects) && width.range().isSubset(NAT.instance) && width.isaFunction() && BRelation.cross(objects,NAT.instance).has(width) &&
		 height.domain().equals(objects) && height.range().isSubset(NAT.instance) && height.isaFunction() && BRelation.cross(objects,NAT.instance).has(height) &&
		 obj_desc.domain().equals(objects) && obj_desc.range().isSubset(NAT.instance) && obj_desc.isaFunction() && BRelation.cross(objects,NAT.instance).has(obj_desc) &&
		 drift.domain().equals(cars) && drift.range().isSubset(new BSet<Integer>(new Integer(-1),new Integer(0),new Integer(1))) && drift.isaFunction() && BRelation.cross(cars,new BSet<Integer>(new Integer(-1),new Integer(0),new Integer(1))).has(drift) &&
		 vel.domain().equals(cars) && vel.range().isSubset(NAT.instance) && vel.isaFunction() && BRelation.cross(cars,NAT.instance).has(vel) &&
		 acc.domain().equals(cars) && acc.range().isSubset(INT.instance) && acc.isaFunction() && BRelation.cross(cars,INT.instance).has(acc) &&
		 maxvel.domain().equals(cars) && maxvel.range().isSubset(NAT.instance) && maxvel.isaFunction() && BRelation.cross(cars,NAT.instance).has(maxvel) &&
		 friction.domain().equals(lanes) && friction.range().isSubset(NAT.instance) && friction.isaFunction() && BRelation.cross(lanes,NAT.instance).has(friction) &&
		 finished.domain().equals(cars) && finished.range().isSubset(BOOL.instance) && finished.isaFunction() && BRelation.cross(cars,BOOL.instance).has(finished) &&
		 active.domain().equals((obstacles.union(cars))) && active.range().isSubset(BOOL.instance) && active.isaFunction() && BRelation.cross((obstacles.union(cars)),BOOL.instance).has(active) &&
		 collision.domain().equals(cars) && collision.range().isSubset(BOOL.instance) && collision.isaFunction() && BRelation.cross(cars,BOOL.instance).has(collision) &&
		 score.domain().equals(cars) && score.range().isSubset(NAT.instance) && score.isaFunction() && BRelation.cross(cars,NAT.instance).has(score); */


	/******Getter and Mutator methods definition******/
	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.acc;*/
	public /*@ pure */ BRelation<Integer,Integer> get_acc(){
		return this.acc;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.acc;
	    ensures this.acc == acc;*/
	public void set_acc(BRelation<Integer,Integer> acc){
		this.acc = acc;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.objects;*/
	public /*@ pure */ BSet<Integer> get_objects(){
		return this.objects;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.objects;
	    ensures this.objects == objects;*/
	public void set_objects(BSet<Integer> objects){
		this.objects = objects;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.obstacles;*/
	public /*@ pure */ BSet<Integer> get_obstacles(){
		return this.obstacles;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.obstacles;
	    ensures this.obstacles == obstacles;*/
	public void set_obstacles(BSet<Integer> obstacles){
		this.obstacles = obstacles;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.right_border;*/
	public /*@ pure */ BRelation<Integer,Integer> get_right_border(){
		return this.right_border;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.right_border;
	    ensures this.right_border == right_border;*/
	public void set_right_border(BRelation<Integer,Integer> right_border){
		this.right_border = right_border;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.active;*/
	public /*@ pure */ BRelation<Integer,Boolean> get_active(){
		return this.active;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.active;
	    ensures this.active == active;*/
	public void set_active(BRelation<Integer,Boolean> active){
		this.active = active;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.obj_desc;*/
	public /*@ pure */ BRelation<Integer,Integer> get_obj_desc(){
		return this.obj_desc;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.obj_desc;
	    ensures this.obj_desc == obj_desc;*/
	public void set_obj_desc(BRelation<Integer,Integer> obj_desc){
		this.obj_desc = obj_desc;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.finished;*/
	public /*@ pure */ BRelation<Integer,Boolean> get_finished(){
		return this.finished;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.finished;
	    ensures this.finished == finished;*/
	public void set_finished(BRelation<Integer,Boolean> finished){
		this.finished = finished;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.friction;*/
	public /*@ pure */ BRelation<Integer,Integer> get_friction(){
		return this.friction;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.friction;
	    ensures this.friction == friction;*/
	public void set_friction(BRelation<Integer,Integer> friction){
		this.friction = friction;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.posX;*/
	public /*@ pure */ BRelation<Integer,Integer> get_posX(){
		return this.posX;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.posX;
	    ensures this.posX == posX;*/
	public void set_posX(BRelation<Integer,Integer> posX){
		this.posX = posX;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.cars;*/
	public /*@ pure */ BSet<Integer> get_cars(){
		return this.cars;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.cars;
	    ensures this.cars == cars;*/
	public void set_cars(BSet<Integer> cars){
		this.cars = cars;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.collision;*/
	public /*@ pure */ BRelation<Integer,Boolean> get_collision(){
		return this.collision;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.collision;
	    ensures this.collision == collision;*/
	public void set_collision(BRelation<Integer,Boolean> collision){
		this.collision = collision;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.posY;*/
	public /*@ pure */ BRelation<Integer,Integer> get_posY(){
		return this.posY;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.posY;
	    ensures this.posY == posY;*/
	public void set_posY(BRelation<Integer,Integer> posY){
		this.posY = posY;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.score;*/
	public /*@ pure */ BRelation<Integer,Integer> get_score(){
		return this.score;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.score;
	    ensures this.score == score;*/
	public void set_score(BRelation<Integer,Integer> score){
		this.score = score;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.finish_line;*/
	public /*@ pure */ BRelation<Integer,Integer> get_finish_line(){
		return this.finish_line;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.finish_line;
	    ensures this.finish_line == finish_line;*/
	public void set_finish_line(BRelation<Integer,Integer> finish_line){
		this.finish_line = finish_line;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.maxvel;*/
	public /*@ pure */ BRelation<Integer,Integer> get_maxvel(){
		return this.maxvel;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.maxvel;
	    ensures this.maxvel == maxvel;*/
	public void set_maxvel(BRelation<Integer,Integer> maxvel){
		this.maxvel = maxvel;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.lanes;*/
	public /*@ pure */ BSet<Integer> get_lanes(){
		return this.lanes;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.lanes;
	    ensures this.lanes == lanes;*/
	public void set_lanes(BSet<Integer> lanes){
		this.lanes = lanes;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.width;*/
	public /*@ pure */ BRelation<Integer,Integer> get_width(){
		return this.width;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.width;
	    ensures this.width == width;*/
	public void set_width(BRelation<Integer,Integer> width){
		this.width = width;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.left_border;*/
	public /*@ pure */ BRelation<Integer,Integer> get_left_border(){
		return this.left_border;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.left_border;
	    ensures this.left_border == left_border;*/
	public void set_left_border(BRelation<Integer,Integer> left_border){
		this.left_border = left_border;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.vel;*/
	public /*@ pure */ BRelation<Integer,Integer> get_vel(){
		return this.vel;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.vel;
	    ensures this.vel == vel;*/
	public void set_vel(BRelation<Integer,Integer> vel){
		this.vel = vel;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.drift;*/
	public /*@ pure */ BRelation<Integer,Integer> get_drift(){
		return this.drift;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.drift;
	    ensures this.drift == drift;*/
	public void set_drift(BRelation<Integer,Integer> drift){
		this.drift = drift;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.height;*/
	public /*@ pure */ BRelation<Integer,Integer> get_height(){
		return this.height;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.height;
	    ensures this.height == height;*/
	public void set_height(BRelation<Integer,Integer> height){
		this.height = height;
	}



	/*@ public normal_behavior
	    requires true;
	    assignable \everything;
	    ensures
		objects.isEmpty() &&
		obstacles.isEmpty() &&
		cars.isEmpty() &&
		lanes.isEmpty() &&
		finish_line.isEmpty() &&
		left_border.isEmpty() &&
		right_border.isEmpty() &&
		posX.isEmpty() &&
		posY.isEmpty() &&
		width.isEmpty() &&
		height.isEmpty() &&
		obj_desc.isEmpty() &&
		drift.isEmpty() &&
		vel.isEmpty() &&
		acc.isEmpty() &&
		maxvel.isEmpty() &&
		friction.isEmpty() &&
		finished.isEmpty() &&
		active.isEmpty() &&
		collision.isEmpty() &&
		score.isEmpty();*/
	public ref2_scoring(){
		objects = new BSet<Integer>();
		obstacles = new BSet<Integer>();
		cars = new BSet<Integer>();
		lanes = new BSet<Integer>();
		finish_line = new BRelation<Integer,Integer>();
		left_border = new BRelation<Integer,Integer>();
		right_border = new BRelation<Integer,Integer>();
		posX = new BRelation<Integer,Integer>();
		posY = new BRelation<Integer,Integer>();
		width = new BRelation<Integer,Integer>();
		height = new BRelation<Integer,Integer>();
		obj_desc = new BRelation<Integer,Integer>();
		drift = new BRelation<Integer,Integer>();
		vel = new BRelation<Integer,Integer>();
		acc = new BRelation<Integer,Integer>();
		maxvel = new BRelation<Integer,Integer>();
		friction = new BRelation<Integer,Integer>();
		finished = new BRelation<Integer,Boolean>();
		active = new BRelation<Integer,Boolean>();
		collision = new BRelation<Integer,Boolean>();
		score = new BRelation<Integer,Integer>();

		events = new Thread[n_events];
		events[0] = new SET_MAXVEL(this);
		events[1] = new SET_DRIFT(this);
		events[2] = new UPDATE_POS(this);
		events[3] = new SET_ZERO_VEL(this);
		events[4] = new DELETE_OBSTACLE(this);
		events[5] = new UPDATE_SCORE(this);
		events[6] = new SET_LEFT_BORDER(this);
		events[7] = new DELETE_CAR(this);
		events[8] = new SET_ACC(this);
		events[9] = new SET_RIGHT_BORDER(this);
		events[10] = new SET_VEL(this);
		events[11] = new FINISHED_LANE(this);
		events[12] = new CAR_RESET(this);
		events[13] = new ADD_LANE(this);
		events[14] = new DELETE_LANE(this);
		events[15] = new OBJECT_COLLISION(this);
		events[16] = new ADD_OBSTACLE(this);
		events[17] = new SET_POS(this);
		events[18] = new APPLY_FRICTION(this);
		events[19] = new ADD_OBJECT(this);
		events[20] = new SET_FINISH_LINE(this);
		events[21] = new UPDATE_VEL(this);
		events[22] = new ADD_CAR(this);
		events[23] = new WALL_COLLISION(this);

		for (int i = 0; i < n_events;i++){
			events[i].start();
		}
	}
}