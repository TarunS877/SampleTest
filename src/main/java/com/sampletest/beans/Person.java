package com.sampletest.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {


    private  String name;
    private  String height;
    private  String mass;
    private  String hair_color;
    private  String skin_color;
    private  String    eye_color;
    private  String   birth_year;
    private  String   gender;
    private  String  homeworld;
    private List<String>     films;
    private List<String>     vehicles;
    private  List<String>   starships;
    private  String created;
    private  String edited;
               private  String url;

}
