public abstract class User {
public String ID;
public String password;

public User(String ID, String password) {
    this.ID = ID;
    this.password = password;
 }

 @Override
public String toString(){
 return ID + " " + password ;
}
}