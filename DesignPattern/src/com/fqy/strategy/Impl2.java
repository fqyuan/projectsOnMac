package com.fqy.strategy;

class Impl2 extends TemplateMethod2 {

	private int state = 1;

	@Override
	protected void preProcess() {
		System.out.println("preProcess ");
	}

	@Override
	protected boolean search() {
		System.out.println("search-" + state++ + " ");
		return state == 3;
	}

	@Override
	protected void postProcess() {
		System.out.println("postProcess ");
	}

}
