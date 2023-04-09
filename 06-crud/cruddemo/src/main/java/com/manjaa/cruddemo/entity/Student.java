package com.manjaa.cruddemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    
    // define the fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // define the constructors

    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define the getters/setters

    public void setId(int id){
        this.id = id;
    }

     public void setFisrstName(String firstName){
        this.firstName = firstName;
     }

     public void setLastName(String lastName){
        this.lastName = lastName;
     }

     public void setEmail(String email){
        this.email = email;
     }

     public int getId(){
        return this.id;
     }

     public String getFirstName(){
        return this.firstName;
     }

     public String getLastName(){
        return this.lastName;
     }

     public String getEmail(){
        return this.email;
     }

     public Student(){
        
     }
    
    //define the tostring() method

    public String toString(){
        return "Student {" +

        "Id: "+this.id +
         ", Firstname=' "+ this.firstName + '\''+
         ", Lastname='"+ this.lastName +'\''+
         ", email='"+ this.email +'\''+
        '}';
    }
    
}
