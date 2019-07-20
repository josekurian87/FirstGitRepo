package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FSTest {
	public static void main(String[] args) {
		processData(12, 4, 7, new int[]{6,2,3,7,1,5,3,9,5,9,1,4});
	}
	
	private static void processData(int ip1, int ip2, int ip3, int[] ip4) {
		ArrayList<Country> cntyList = new ArrayList<Country>();
		int[] stList = new int[ip2];
		int[] tempList = new int[ip2];
		for(int i=0;i<ip4.length;i++) {
			stList[i%ip2] = ip4[i];
			tempList[i%ip2] = ip4[i];
			//System.out.print("A "+i%ip2);
			//System.out.print("\tB "+i/ip2);
			//System.out.println("\tC "+(i+1)%ip2);
			if(i%ip2==(ip2-1)) {
				StringBuffer rank = new StringBuffer();
				Arrays.sort(tempList);
				for(int r:tempList) {
					rank.append(r+"");
				}
				cntyList.add(new Country((i+1)/ip2, Integer.parseInt(rank.toString()), stList));
				stList = new int[ip2];
			}
		}
		
		Collections.sort(cntyList);
		int counter = 0;
		for(Country c:cntyList) {
			//System.out.println(c.getId() +"\t"+c.getRank()+"\t"+Arrays.toString(c.getStList()));
			for(int v:c.getStList()) {
				counter++;
				if(counter == ip3) {
					System.out.println("Result: {"+c.getId()+","+v+"}");
				}
			}
		}
		
	}
}

class Country implements Comparable<Country>{
	private int id;
	private int rank;
	private int[] stList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int[] getStList() {
		return stList;
	}
	public void setStList(int[] stList) {
		this.stList = stList;
	}
	
	public Country(int id, int rank, int[] stList) {
		super();
		this.id = id;
		this.rank = rank;
		this.stList = stList;
	}

	@Override
	public int compareTo(Country arg0) {
		return Integer.valueOf(this.rank).compareTo(arg0.rank);
	}
	
}