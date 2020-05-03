package RoadFighter_2020_multi_threaded; 

import eventb_prelude.*;
import Util.Utilities;

public class SET_VEL extends Thread{
	/*@ spec_public */ private ref2_scoring machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public SET_VEL(ref2_scoring m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_cars().has(Car) && NAT.instance.has(V) && (V).compareTo(machine.get_maxvel().apply(Car)) <= 0); */
	public /*@ pure */ boolean guard_SET_VEL( Integer Car, Integer V) {
		
		return (machine.get_cars().has(Car) && NAT.instance.has(V) && (V).compareTo(machine.get_maxvel().apply(Car)) <= 0);
	}

	/*@ public normal_behavior
		requires guard_SET_VEL(Car,V);
		assignable machine.vel;
		ensures guard_SET_VEL(Car,V) &&  machine.get_vel().equals(\old((machine.get_vel().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(Car,V)))))); 
	 also
		requires !guard_SET_VEL(Car,V);
		assignable \nothing;
		ensures true; */
	public void run_SET_VEL( Integer Car, Integer V){		
		if(guard_SET_VEL(Car,V)) {
			BRelation<Integer,Integer> vel_tmp = machine.get_vel();

			machine.set_vel((vel_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(Car,V)))));

			System.out.println("SET_VEL executed Car: " + Car + " V: " + V + " ");
		}
	}

	public void run() {
		while(true) {
			Integer Car = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			Integer V = Utilities.someVal(new BSet<Integer>((new Enumerated(1,Utilities.max_integer))));
			machine.lock.lock(); // start of critical section
			run_SET_VEL(Car,V);
			machine.lock.unlock(); // end of critical section
		}
	}
}
