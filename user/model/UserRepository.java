package com.seveneleven.mycontactsapp.user.model;

/**
*
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


