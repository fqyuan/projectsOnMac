package com.fqyuan.enumerted;

import static com.fqyuan.enum1.AlarmPoints.BATHROOM;
import static com.fqyuan.enum1.AlarmPoints.KITCHEN;
import static com.fqyuan.enum1.AlarmPoints.UTILITY;
import static com.fqyuan.utils.Print.print;
import static com.fqyuan.utils.Print.printnb;

import java.util.EnumMap;
import java.util.Map;

import com.fqyuan.enum1.AlarmPoints;

/*
 *  Command design pattern:
 *  An interface containing a single method
 *  creates multiple implementations with different behavior for that method.
 *  You install Command objects, your program calls them when necessary.
 */
public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(KITCHEN, new Command() {
			@Override
			public void action() {
				// TODO Auto-generated method stub
				print("Kitchen fire!");
			}
		});
		em.put(BATHROOM, new Command() {

			@Override
			public void action() {
				// TODO Auto-generated method stub
				print("Bathroom alert!");
			}
		});
		for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
			printnb(e.getKey() + ": ");
			e.getValue().action();
		}

		try {
			// If there's no value for a particular key:
			em.get(UTILITY).action();
		} catch (Exception e) {
			print(e);
		}
	}
}
