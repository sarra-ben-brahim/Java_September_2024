package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician implements HIPAACompliantUser {
  private ArrayList<String> patientNotes;
  private int id;
  private int pin;
  private Integer confirmedAuthid;

  public Physician(int id) {
    this.id = id;
    this.patientNotes = new ArrayList<String>();
  }

  public void newPatientNotes(String notes, String patientName, Date date) {
    String report = String.format("Datetime Submitted: %s \n", date);
    report += String.format("Reported By id: %s\n", this.id);
    report += String.format("Patient Name: %s\n", patientName);
    report += String.format("Notes: %s \n", notes);
    this.patientNotes.add(report);
  }



  @Override 
  public boolean assignPin(int pin) {
    if (pin < 1000 || pin > 9999) {
      return false;
    }
    this.pin = pin;
    return true;
  }

  public boolean accessAuthorized(int id) {
    int val = this.id;
    return val == id;
  }

  public ArrayList<String> getPatientNotes() {
    return patientNotes;
  }

  public void setPatientNotes(ArrayList<String> patientNotes) {
    this.patientNotes = patientNotes;
  }

  public int getid() {
    return id;
  }

  public void setid(int id) {
    this.id = id;
  }

  @Override
  public boolean accessAuthorized(Integer confirmedAuthID) {
    return this.id == confirmedAuthID;
  }

}
