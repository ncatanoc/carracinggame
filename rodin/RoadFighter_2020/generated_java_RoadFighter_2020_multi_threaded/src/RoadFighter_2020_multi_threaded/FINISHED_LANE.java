package RoadFighter_2020_multi_threaded; 

import eventb_prelude.*;
import Util.Utilities;

public class FINISHED_LANE extends Thread{
	/*@ spec_public */ private ref2_scoring machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public FINISHED_LANE(ref2_scoring m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_cars().has(Car) && machine.get_lanes().has(Lane)); */
	public /*@ pure */ boolean guard_FINISHED_LANE( Integer Car, Integer Lane) {
		return (machine.get_cars().has(Car) && machine.get_lanes().has(Lane));
	}

	/*@ public normal_behavior
		requires guard_FINISHED_LANE(Car,Lane);
		assignable machine.finished;
		ensures guard_FINISHED_LANE(Car,Lane) &&  machine.get_finished().equals(\old((machine.get_finished().override(new BRelation<Integer,Boolean>(new Pair<Integer,Boolean>(Car,((machine.get_posY().apply(Car)).compareTo(machine.get_finish_line().apply(Lane)) > 0))))))); 
	 also
		requires !guard_FINISHED_LANE(Car,Lane);
		assignable \nothing;
		ensures true; */
	public void run_FINISHED_LANE( Integer Car, Integer Lane){
		if(guard_FINISHED_LANE(Car,Lane)) {
			BRelation<Integer,Boolean> finished_tmp = machine.get_finished();

			machine.set_finished((finished_tmp.override(new BRelation<Integer,Boolean>(new Pair<Integer,Boolean>(Car,((machine.get_posY().apply(Car)).compareTo(machine.get_finish_line().apply(Lane)) > 0))))));

			System.out.println("FINISHED_LANE executed Car: " + Car + " Lane: " + Lane + " ");
		}
	}

	public void run() {
		while(true) {
			Integer Car = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			Integer Lane = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			machine.lock.lock(); // start of critical section
			run_FINISHED_LANE(Car,Lane);
			machine.lock.unlock(); // end of critical section
		}
	}
}
