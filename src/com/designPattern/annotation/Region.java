package com.designPattern.annotation;
public class Region {
    private String name = "";
    private Country country = null;
    
    public Region(String name, Country country) {
        this.name = name;
        this.country = country;
        this.country.addRegion(this);
    }

    public void setName(String name){
        this.name = name;
    }
    
    @Unique(scope = Country.class)
    public String getName(){
        return this.name;
    }
    
    public Country getCountry(){
        return country;
    }
}