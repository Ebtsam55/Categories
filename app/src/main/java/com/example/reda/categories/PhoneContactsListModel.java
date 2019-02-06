package com.example.reda.categories;

import java.io.Serializable;
import java.util.ArrayList;

public class PhoneContactsListModel implements Serializable  {

    private ArrayList<String>  contactsList =new ArrayList<>();

    public PhoneContactsListModel() {
    }

    public ArrayList<String> getContactsList() {
        return contactsList;
    }

    public void setContactsList(ArrayList<String> contactsList) {
        this.contactsList = contactsList;
    }
}
