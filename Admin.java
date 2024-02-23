/**
 * 
 */
public class Admin extends User{
    
    /**
     * 
     * @param username
     * @param password
     * @param fristname
     * @param lastname
     */
    public Admin(String username, String password, String fristname, String lastname)
    {
        super(username, password, fristname, lastname);
    }

    /**
     * 
     */
    public void addCourse()
    {
        System.out.println("added course");
    }

    /**
     * 
     */
    public void notOfferCourse()
    {
        System.out.println("course no longer offered");
    }

    /**
     * 
     * @return
     */
   public boolean checkStudentPermission()
   {
        return true;
   }
}
