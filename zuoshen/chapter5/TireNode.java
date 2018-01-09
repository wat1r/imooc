package com.alogrithm.tire;

public class TireNode {

	public int path;
	public int end;
	public TireNode[] map;

	public TireNode() {
		this.path = 0;
		this.end = 0;
		this.map = new TireNode[26];
	}

}
