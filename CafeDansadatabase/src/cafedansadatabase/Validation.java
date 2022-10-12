package cafedansadatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
 * Class         Validation - default constructor
 * File name     Validation.java
 * Description   Provides a number of Boolean methods for validationing different 
 *               types using regular expressions
 * Platform      jdk 1.8.0_51-b16, NetBeans IDE 15 Windows 10
 * Course        CS 142
 * Date          10/7/2022
 * @author       <i>Abylay Dospayev</i>
 * @version      1.0.0
 * @see          java.util.regex.Matcher
 * @see          java.util.regex.Pattern
∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
public class Validation {
    //email validation
    public final static String EMAIL_PATTERN = 
            "^\\s*[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\\s*$";
    //number validation
    public final static String PHONE_PATTERN = 
            "\\D{0,1}([0-9]\\d{2})(\\D*)([0-9]\\d{2})(\\D*)(\\d{4})";
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isDouble()
    * Description   Validates that double value is entered
    * @author       <i>Abylay Dospayev</i>
    * @param        fieldValue String
    * @return       boolean
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isDouble(String fieldValue)
    {
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isDouble()
    * Description   Overloaded, validates that double value is entered
    *               within the required range
    * @author       <i>Abylay Dospayev</i>
    * @param        fieldValue double, lower bound
    * @param        lower double, lower bound
    * @param        upper double, upper bound
    * @return       boolean
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isDouble(String fieldValue, double lower, double upper)
    {
        boolean result = true;
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        if(mat.matches())
        {
            try
            {
                //check range 
                double num = Double.parseDouble(fieldValue);
                if (num < lower || num > upper) 
                    result = false;
            }
            catch(NumberFormatException ex)
            {
                //something went wrong
                result = false;
            }

            
        }
        else 
        {
            result = false;
        }
        return result;
        //return mat.matches(); 
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isInteger()
    * Description   Validates that entered value is an integer
    * @return       boolean
    * @author       <i>Abylay Dospayev</i>
    * @param        fieldValue: String, input
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isInteger(String fieldValue, int MAX, int MAX1){
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isEmpty()
    * Description   Validates that JTextField is not empty
    * @return       boolean
    * @author       <i>Abylay Dospayev</i>
    * @param        fieldValue: JTextField, input
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * @see          javax.swing.JTextField
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isEmpty(JTextField fieldValue)
    {
        String input = fieldValue.getText();
        if (input == null || input.length() <= 0 || input.equals(""))
            return true;
        else 
            return false;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isValidName()
    * Description   Validates that JTextField is a valid name
    * @return       boolean
    * @author       <i>Abylay Dospayev</i>
    * @param        input: JTextField, input
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * @see          javax.swing.JTextField
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isValidName(String input)
    {
        final short MAX_LENGTH = 40;
        final short MIN_LENGTH = 2;
        boolean result = true;
        Pattern pat = Pattern.compile("^[a-zA-Z\\s\\.\\-\\']{2,40}$");
        Matcher mat = pat.matcher(input);
        if (!mat.matches() || input.length() > MAX_LENGTH || input.length() < MIN_LENGTH)
         result = false;
        return result;
    }
    
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isPhone()
    * Description   Validates that JTextField is a valid phone number
     *@param        field String
    * @return       boolean
    * @author       <i>Abylay Dospayev</i>
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * @see          javax.swing.JTextField
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isPhone(String field) {
        String noLetters = "[^A-Za-z]+";
        return field.matches(PHONE_PATTERN) && field.matches(noLetters);
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
    * <pre>
    * Method        isEmail()
    * Description   Validates that JTextField is a valid email address
     *@param        field String
    * @return       boolean
    * @author       <i>Abylay Dospayev</i>
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * @see          javax.swing.JTextField
    * Date          10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public static boolean isEmail(String field) {
        return field.matches(EMAIL_PATTERN);
    }
    
}
