package com.sampletest.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    private String name;
    private String model ;
    private String manufacturer ;
    private String cost_in_credits ;
    private double length ;
    private long max_atmosphering_speed ;
    private int crew ;
    private int  passengers ;
    private int  cargo_capacity ;
    private String consumables ;
    private String vehicle_class ;
    private String created;
    private String edited;
    private String url ;
}
