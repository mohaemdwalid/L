public class Reader extends User {
    public String type;
    public String FirstName;
    public String LastName;
    public String Address;
    public String CellPhone;
    public String Email;
    public Boolean isBlocked;

    
    public Reader(String ID,String password ,String type,String FirstName, String LastName, String Address, String CellPhone, String Email,Boolean isBlocked) {
        super(ID, password);
        this.type = type;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.CellPhone = CellPhone;
        this.Email = Email;
        this.isBlocked = isBlocked;
    }
    @Override
    public String toString()
    {
    return super.toString()+ " " + type + " " + Address + " " + FirstName + " " + LastName+ " " + Address+ " " + CellPhone + " " + Email;
    }
}