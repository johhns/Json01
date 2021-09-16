package com.example.json01.Modelo;

public class Pais {

    private String alpha3Code ;
    private String name ;
    private int    population ;
    private String alpha2Code ;

    public String getCodido() {
        return alpha3Code;
    }

    public void setCodigo(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return alpha2Code;
    }

    public void setFlag(String flag) {
        this.alpha2Code = flag;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // by johhns
}
