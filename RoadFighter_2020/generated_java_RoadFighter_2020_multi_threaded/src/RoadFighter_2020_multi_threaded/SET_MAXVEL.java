package RoadFighter_2020_multi_threaded; 

import eventb_prelude.*;
import Util.Utilities;

public class SET_MAXVEL extends Thread{
	/*@ spec_public */ private ref2_scoring machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public SET_MAXVEL(ref2_scoring m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_cars().has(Car) && NAT.instance.has(M) && (M).compareTo(machine.get_vel().apply(Car)) >= 0); */
	public /*@ pure */ boolean guard_SET_MAXVEL( Integer Car, Integer M) {
		return (machine.get_cars().has(Car) && NAT.instance.has(M) && (M).compareTo(machine.get_vel().apply(Car)) >= 0);
	}

	/*@ public normal_behavior
		requires guard_SET_MAXVEL(Car,M);
		assignable machine.maxvel;
		ensures guard_SET_MAXVEL(Car,M) &&  machine.get_maxvel().equals(\old((machine.get_maxvel().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(Car,M)))))); 
	 also
		requires !guard_SET_MAXVEL(Car,M);
		assignable \nothing;
		ensures true; */
	public void run_SET_MAXVEL( Integer Car, Integer M){
		if(guard_SET_MAXVEL(Car,M)) {
			BRelation<Integer,Integer> maxvel_tmp = machine.get_maxvel();

			machine.set_maxvel((maxvel_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(Car,M)))));

			System.out.println("SET_MAXVEL executed Car: " + Car + " M: " + M + " ");
		}
	}

	public void run() {
		while(true) {
			Integer Car = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			Integer M = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			machine.lock.lock(); // start of critical section
			run_SET_MAXVEL(Car,M);
			machine.lock.unlock(); // end of critical section
		}
	}
}
