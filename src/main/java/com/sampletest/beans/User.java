package com.sampletest.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private  long id;
    private  String  name;
    private  String  email;
    private  String  gender;
    private  String  status;
    private  String  created_at;
    private  String  updated_at;
}
