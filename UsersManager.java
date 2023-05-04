import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsersManager {
HashMap<String,User> allUsers;
 public UsersManager(){
         allUsers = new HashMap<String, User>();

         User user = new Admin( "admin", "123");
         allUsers.put(user.ID, user);


         user = new Reader("user1","1234","male","mo","walid","3n shmis","02122","xdx@",false);
         allUsers.put(user.ID, user);

         user = new Reader("user2","1234","male","ahmed","mazen","3n shmis","02124442","xdx@",true);
         allUsers.put(user.ID, user);

         user = new Reader("user3","1234","male","mo","walid","3n shmis","02132222","xdx@",true);
         allUsers.put(user.ID, user);

    }


   //  check login 
    public User Login(String id, String password){
         User result = allUsers.get(id);
         if(result !=null && result.password.equals(password)){
            return result;
         }
         else
            return null;
    }
    
   // create a new user
   public Boolean Register(String ID,String password ,String type,String FirstName, String LastName, String Address, String CellPhone, String Email,Boolean isBlocked){
         if(allUsers.get(ID) == null){
            User newUser = new Reader(ID, password, type, FirstName,LastName, Address,CellPhone,Email,isBlocked = null);
            allUsers.put(newUser.ID, newUser);
         return true;
         }
         return false;
         }
    // Delete user
   public  Boolean deleteUser(String Name) {
      return allUsers.remove(Name) != null;
   }     


   // view block account
   // public void viewBlocked(){
   //    Set<String> set = allUsers.keySet();
   //    for (String key  : set) {
   //       User vl = allUsers.get(key);
   //       System.out.println(vl.equals(set));
   //   }
   // }

}
   

   
         
