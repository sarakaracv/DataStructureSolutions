package org.example.groupweeks.week27.phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertPhone {
    /*
    1. Implement a phone book using a linked list structure. In this phone book, you are going to store a name, last
name, email, and phone number.
2. Implement an insert operation to the phone book. With the insert operation, you're going to add the name, last
name, email, and phone number of the person.
3. Implement the following methods:
* findByName: Will return the information of the first record matching the name you send.
• findAllByLastName: Will return an ArrayList of all entries matching the last name you send.
• deleteByName: Will delete the first record matching the name you send to this method.
• deleteAllMatchingLastName: Will delete all entries matching the last name.
• findAll: Return all records as an ArrayList.
• printPhoneBook: Will print all entries in the phone book.
     */
   // List<String> list= new ArrayList<>();

    public HashMap<String,String> findByName(String namekey, String findname){
        HashMap<String,String> map=new HashMap<>();
        if (map.values().equals(findname))
            map.get(findname);
        return map;
    }

    public ArrayList<String> saveLastName(ArrayList<String> lastName){
        List<String> list1= new ArrayList<>();
        if (!list1.contains(lastName))
        list1.add(lastName.get(0));
        return lastName;
    }




}
