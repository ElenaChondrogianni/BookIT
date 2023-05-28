package BookIT;

public  class User
{
    private long userID = 0;
    private String username="";
    private String email="";
    private String password="";
    

    //Constructor
    public User(String username, String email, String password1, String password2, boolean agreement)
    {
        try{
            if((checkUsername(username))&(checkEmail(email))&(checkPasswordSafety(password1))&(checkPasswordMatch(password1, password2))&(checkAgreement(agreement))){
                this.username=username;
                this.email=email;
                this.password=password1;
                this.userID= Integer.parseInt(createID());
            }else throw new IllegalArgumentException();
        }catch(IllegalArgumentException e){e.toString();}

    }

    private synchronized String createID()
    {
        return String.valueOf(userID++);
    }
    //Επιστρέφει το email
    public String getEmail(){
        return email;
    }

    //Επιστρέφει το όνομα χρήστη
    public String  getUsername(){
        return username;
    }

    
    //Θέτει το όνομα 
    public void setUsername(String newUsername){
        this.username=newUsername;
    }
    
    //Ελέγχει αν υπάρχει user με αυτό το email και τον επιστρέφει
    public boolean checkEmail(String email){
        User oldUser = null;
        for (User user: Marketplace.users)
        {
            if(user.getEmail().equals(email)==true)  oldUser = user; 
        }
        if(oldUser!=null)  return false;
        else return true;       
    }
    
    public boolean checkUsername(String username){
    User oldUser = null;
        for (User user: Marketplace.users)
        {
            if(user.getUsername().equals(username)==true)  oldUser = user; 
        }
        if(oldUser!=null)  return false;
        else return true;       
    }
    
    public boolean checkAgreement(boolean agreement){
        if(agreement==true) return agreement;
        else return false;
    }
    
    public boolean checkPasswordSafety(String password){
            
        char ch;
        boolean num=false;
        boolean upper=false;
        
        if(password.length()<8) return false;
    
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if(Character.isDigit(ch)) {
                num = true;
            }
            else if (Character.isUpperCase(ch)) {
                upper = true;
            }
        }
        if((num==true)&(upper==true)) return true;
        else return false;
    }
    
    public boolean checkPasswordMatch(String password1, String password2){
        if(password1.matches(password2)) return true;
        else return false;
    }
}













 