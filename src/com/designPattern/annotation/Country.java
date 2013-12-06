package com.designPattern.annotation;
import java.util.ArrayList;
import java.util.List;


public class Country {
	private List<Region> regions = new ArrayList<Region>();
	private String name;
	
	public Country(String name){
		this.name = name;
	}
	
	@MaxLength(length = 10)
	public String getName(){
		return name;
	}
	
	public void addRegion(Region region){
		regions.add(region);
	}
	
	public List<Region> getRegions(){
		return regions;
	}
}