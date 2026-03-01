package com.seveneleven.mycontactsapp.user.model;

/**
* Project - My ContactApp
* @author Harsheen
* @version 4.0
* This creates a user repo to store the details of contacts in list data structure
* */

import java.util.*;
public class UserRepository {
   private static List<User> users = new ArrayList<>();

   public static User findByEmail(String email) {
       for(User user : users) {
           if(user.getEmail().equalsIgnoreCase(email)) {
               return user;
           }
       }
       return null; // return null if not found
   }

   public static void save(User user) {
       users.add(user);
   }
}
 

