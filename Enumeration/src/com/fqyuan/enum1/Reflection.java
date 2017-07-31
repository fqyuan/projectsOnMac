package com.fqyuan.enum1;

import static com.fqyuan.utils.Print.print;
import static com.fqyuan.utils.Print.printnb;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

public class Reflection {
	public static Set<String> analyze(Class<?> enumClass) {
		print("----- Analyzing " + enumClass + " -----");
		print("Interface:");
		/*
		 * Type is the common superinterface for all types in the Java
		 * programming language. Including raw types, parameterized types, array
		 * types, type variables and primitive types
		 */
		/*
		 * getGenericInterfaces():return an array of interfaces implemented by
		 * this class
		 */
		for (Type t : enumClass.getGenericInterfaces())
			print(t);
		/*
		 * getSuperclass():return the superclass of the class
		 */
		print("Base: " + enumClass.getSuperclass());
		print("Methods: ");
		Set<String> methods = new TreeSet<String>();
		/*
		 * return: the array of the Method object representing the public
		 * methods of the class
		 */
		for (Method m : enumClass.getMethods())
			methods.add(m.getName());
		print(methods);

		return methods;
	}

	public static void main(String[] args) {
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
		printnb("Explore.removeAll(Enum): ");
		exploreMethods.removeAll(enumMethods);
		print(exploreMethods);
		// Decompile the code for the enum:
		// OSExecute.command("javap Explore");
	}

}
