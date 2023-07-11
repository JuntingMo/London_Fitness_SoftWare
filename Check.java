import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class checking the validation of user's information
 * @author  Jingxuan Wang
 * @version 1.0
 */ 
public class Check {
	public Check() {
		
	}
	
	/**The method for checking the validation of user's email address.
     * @author Jingxuan Wang
	 * @param str  The user's email address.
	 * @return boolean
	 */
    public boolean checkEmail(String str){
    	//Use regular expression to check the email address
        String emailRule = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(emailRule);
        Matcher m = p.matcher(str);
        return m.matches();  
    }
    
    /**The method for checking the validation of user's password.
	 * @author Jingxuan Wang
	 * @param str  The user's password.
	 * @return boolean
	 */
    public boolean checkPassword(String str){
    	int a = 0, b= 0;
    	
    	//Check the length of the password
        if(str.length() < 6 || str.length() > 10){
            return false;
        }
        
        for(int i=0; i < str.length(); i++){
        	//Check if there's any digit in the password
        	if(str.charAt(i) <= '9' && str.charAt(i) >= '0')
            	a = 1;
            else if((str.charAt(i) <= 'z' && str.charAt(i) >= 'a') 
            		|| (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A')) //Check if there's any letter in the password
                b = 1;
            else
                return false;
        }
        if(a == 0 || b == 0){
            return false;
        }
        
        //The password is valid
        return true; 
    }
}
