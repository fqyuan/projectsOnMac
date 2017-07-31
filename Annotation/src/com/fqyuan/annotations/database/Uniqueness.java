package com.fqyuan.annotations.database;

//Sample of nested annotations
public @interface Uniqueness {
	Constraints constraints() default @Constraints(unique = true);
}
