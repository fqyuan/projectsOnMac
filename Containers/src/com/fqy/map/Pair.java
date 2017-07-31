package com.fqy.map;

class Pair<K, V> {
	// The field are made public and final, so the class
	// became a read-only Data Transfer Object(or Messager).
	public final K key;
	public final V value;

	public Pair(K k, V v) {
		key = k;
		value = v;
	}
}
