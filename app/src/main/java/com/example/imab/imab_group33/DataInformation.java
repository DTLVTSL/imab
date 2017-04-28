package com.example.imab.imab_group33;

//display all the information


public class DataInformation {

    private String CodiceFiscale;
    private String name;
    private String Surname;
    private String datebirth;

    public DataInformation(){

    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String CodiceFiscale) {
        this.CodiceFiscale = CodiceFiscale;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public String getdatebirth() {
        return datebirth;
    }

    public void setdatebirth(String datebirth) {
        this.datebirth = datebirth;
    }
}