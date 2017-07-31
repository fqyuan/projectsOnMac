package com.fqyuan.enum1;

import static com.fqyuan.enum1.AlarmPoints.BATHROOM;
import static com.fqyuan.enum1.AlarmPoints.KITCHEN;
import static com.fqyuan.enum1.AlarmPoints.OFFICE1;
import static com.fqyuan.enum1.AlarmPoints.OFFICE4;
import static com.fqyuan.enum1.AlarmPoints.STAIR1;
import static com.fqyuan.enum1.AlarmPoints.STAIR2;
import static com.fqyuan.utils.Print.print;

import java.util.EnumSet;

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);// Empty
		// set
		points.add(BATHROOM);
		print(points);
		points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		print(points);
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		print(points);
		points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
		print(points);
		points = EnumSet.complementOf(points);
		print(points);
	}

}
