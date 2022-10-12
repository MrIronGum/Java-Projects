package cafedansadatabase;
/**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼  
 * <pre>
 * File name     Dancer.Java
 * Description   A class representing a Dancer Database with 6 properties: name, 
 *               dance preference style, proficiency, length in years of dancing,
 *               phone and email
 * Project       Cafe Dansa Database
 * Platform      jdk 1.8.0_51-b16, NetBeans IDE 15 Windows 10
 * Course        CS 142
 * Hours         5 hours and 20 minutes
 * Date          10/10/2022
 * @author       <i>Abylay Dospayev</i>
 * @version     1.0.0
 * </pre>
∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
public class Dancer {
    private String name;
    String style;
    private String proficiency;
    private int years;
    private String phone;
    private String email;
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Constructor     Dancer() - default constructor
    *   Description     Create an instance of the Dancer class and assigns 
    *                   default values to all fields
    *   @author         <i>Abylay Dospayev</i>
    *   Date            9/23/2022  
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public Dancer()
    {
        name = "";
        style = "";
        proficiency = "";
        years = 0;
        phone = "";
        email="";
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Constructor     Dancer() - overloaded constructor
    *   Description     Create an instance of the Dancer class and assigns 
    *                   values via parameters
    *   @author         <i>Abylay Dospayev</i>
    *   @param          name String
    *   @param          style String
    *   @param          level String 
    *   @param          years int
    *   @param          phone String 
    *   @param          email String
    * 
    *   Date            9/23/2022 
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
     public Dancer( String name, String style, String level, int years, String phone, String email)
    {
        this.name = name; 
        this.style = style;
        proficiency = level; 
        this.years = years;
        this.phone = phone;
        this.email = email;
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Constructor     City() - overloaded copy constructor
    *   Description     Create an instance of the City class and assigns 
    *                   default values via parameteres from another Dancer to all fields
    *   @author         <i>Abylay Dospayev</i>
    *   @param          anotherDancer Dancer
    *   Date            9/23/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
      public Dancer(Dancer anotherDancer)
    {
       this.name = anotherDancer.name;
       this.style = anotherDancer.style;
       proficiency = anotherDancer.proficiency;
       this.years = anotherDancer.years;
       this.phone = anotherDancer.phone;
       this.email = anotherDancer.email; 
    }
      /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getName()
    *   Description     Get method to return instance variable name.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         name String
    *   Date            9/23/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/ 
    public String getName() {
        return name;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setName()
    *   Description     Set method to set instance variable name
    *   @author         <i>Abylay Dospayev</i>
    *   @param          name String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/ 
    public void setName(String name) {
        this.name = name;
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getStyle()
    *   Description     Get method to return instance variable style.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         style String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public String getStyle() {
        return style;
    }
     /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setStyle()
    *   Description     Set method to set instance variable style
    *   @author         <i>Abylay Dospayev</i>
    *   @param          style String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/ 
    public void setStyle(String style) {
        this.style = style;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getProficiency()
    *   Description     Get method to return instance variable proficiency.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         proficiency String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public String getProficiency() {
        return proficiency;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setProficiency()
    *   Description     Set method to set instance variable proficiency
    *   @author         <i>Abylay Dospayev</i>
    *   @param          proficiency String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getYears()
    *   Description     Get method to return instance variable years.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         years int
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public int getYears() {
        return years;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setYears()
    *   Description     Set method to return instance variable years.
    *   @author         <i>Abylay Dospayev</i>
    *   @param years
    * </pre>
    *∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    
    public void setYears(int years) {
        this.years = years;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getPhone()
    *   Description     Get method to return instance variable phone.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         phone String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public String getPhone() {
        return phone;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setPhone()
    *   Description     Set method to return instance variable phone.
    *   @author         <i>Abylay Dospayev</i>
    *   @param          phone String    
    * </pre>    
    *∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          getEmail()
    *   Description     Get method to return instance variable email.
    *   @author         <i>Abylay Dospayev</i>
    *   @return         email String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public String getEmail() {
        return email;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          setEmail()
    *   Description     Set method to return instance variable email.
    *   @author         <i>Abylay Dospayev</i>
    *   @param          email String   
    *   Date            10/10/2022
    * </pre>    
    *∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    public void setEmail(String email) {
        this.email = email;
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          toString()
    *   Description     Overriden toString() method to display a Dancer object 
    *   @author         <i>Abylay Dospayev</i>
    *   @return         Dancer object String
    *   Date            10/10/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    @Override
    public String toString(){
        
        return "Dancer's name: " + name + "\nStyle of Dancing: " + style +
                "\nProficiency: " + proficiency + "/nYears of dancing: " + years + 
                "\nPhone: " + phone + "/nEmail: "+ email;
        
    }
    /**∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼
    * <pre>
    *   Method          equals()
    *   Description     Own method to check if one City object equals to another     
    *   @author         <i>Abylay Dospayev</i>
    *   @return         true or false boolean
    *   Date            9/23/2022
    * </pre>
    ∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼∼*/
    @Override
    public boolean equals(Object obj)
    {
        Dancer dancer = new Dancer();
        if (obj instanceof Dancer)
        {
            dancer = (Dancer) obj;
            return this.getName().equalsIgnoreCase(dancer.getName())&&
                    (this.getYears() == dancer.getYears())&& this.getStyle().equalsIgnoreCase(dancer.getStyle());
        }
        else 
            return false;   //not the same class
    
    }   

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
