package org.example.groupweeks.week27.phoneBook;

import java.util.ArrayList;

public interface Crud <T,ID>{
    public String findByName(String name,String findname);
    public ArrayList<Phone> findAllByLastName();
//    public deleteByName();
//    public deleteAllMatchingLastName();
//    public findAll();
//    public printPhoneBook();



}
