package Models.Abstract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* REFERENCE:   http://tutorials.jenkov.com/java-reflection/index.html */

/**
 *
 * @author Paul Millar <D00152098>
 */
public abstract class ErrorBase {
    
    // <editor-fold defaultstate="collapsed" desc="Properties">  

    private transient ArrayList<String> errorMessages;
   
    // </editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="Getters"> 
    
    public List<String> getErrorMessages(){
        return this.errorMessages;
    }
    
    public int errorCount() {
        return this.errorMessages.size();
    }

    public String[] toArray() {
        return errorMessages.toArray(new String[this.errorMessages.size()]);
    }

    public String toErrorString(){
        
      StringBuilder sb = new StringBuilder();
      
      for(String s : errorMessages){
          sb.append(s);
          sb.append("\n");
      }
      
      return sb.toString();

    }

    // </editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="Annotations">
    
    @Retention(RetentionPolicy.RUNTIME) // Allows the annotation to be accessed via reflection at runtime.
    @Target(ElementType.FIELD)          // Can only be used on top of fields.
    protected @interface RequiredValidator {
    }

    
    @Retention(RetentionPolicy.RUNTIME) // Allows the annotation to be accessed via reflection at runtime.
    @Target(ElementType.FIELD)          // Can only be used on top of fields. 
    protected @interface RangeValidator {
        public double minValue();
        public double maxValue();
    }
    
    // </editor-fold>     
    
    // <editor-fold defaultstate="collapsed" desc="Validators">
        
    
    private void addRequiredError(String fieldName){
        this.errorMessages.add("The field '" + formatName(fieldName) + "' is required.");
    }
    
    private void addRangeError(String fieldName, double min, double max){
        this.errorMessages.add("The field '" + formatName(fieldName) + "' must be between " + min + " and " + max);
    }
        
    private void reset(){
        if(this.errorMessages == null){
            this.errorMessages = new ArrayList<String>();
        } else {
            this.errorMessages.clear();
        }
    }
    
    public boolean isValid() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{

        // Reset Everything
        this.reset();

        // Get the class object for the sub class.
        Class<?> theSubClass = Class.forName(this.getClass().getName());
        
        Field[] fields = theSubClass.getDeclaredFields();
        
        // Loop through all of it's declared fields.
        for(Field field : fields){
            
            // Check if the '@RequiredValidator' annotation is present for this field.
            if(field.isAnnotationPresent(RequiredValidator.class)){
                
                // Make sure we can access the field even if it has a 'private' access modifier.
                field.setAccessible(true);
                
                // Check that it has a value.
                validateRequiredField(field);
                
            }   
            
            // Check if the '@RangeValidator' annotation is present for this field.
            if(field.isAnnotationPresent(RangeValidator.class)){
                
                // Make sure we can access the field even if it has a 'private' access modifier.
                field.setAccessible(true);
                
                // Check that the value is within range.
                validateRangeField(field);                
            }
        }
               
        
        // Determine if this object is valid.
        return this.errorCount() == 0;

    }

    private void validateRequiredField(Field field) throws IllegalArgumentException, IllegalAccessException{
        
        String type = field.getType().toString();
        
        // PRIMITIVE TYPES ARE IGNORED WITH THE EXCEPTION OF 'CHAR'.
        
        try{
            // STRING
            if(type.endsWith("String")){
                String str = (String)field.get(this);
                // Check if this field has a value.
                if(str.isEmpty() || str.trim().equals("")){
                    addRequiredError(field.getName());
                }
            } 
            // CHAR
            else if(type.endsWith("char")){
                char chr = field.getChar(this);
                // Check if this field has a valid value.
                if(chr == 0x0 || chr == '\u0000' || Character.isWhitespace(chr)){
                    addRequiredError(field.getName());
                }
            }          
            // OBJECTS (Just tests if the object is null).  
            else {
                Object obj = field.get(this);                
                // Dummy Line to force a NullPointerException if indeed the object is null.
                Object obj2 = obj.getClass();
            }
        }
        // CATCH NULL POINTER (ALSO A VIOLATION).
        catch (NullPointerException npe){
            addRequiredError(field.getName());
        }
        
    }
    
    private void validateRangeField(Field field) throws IllegalArgumentException, IllegalAccessException{

        // Get the minimum & maximum values from the annotation associated with this field.
        RangeValidator rv = (RangeValidator)field.getAnnotation(RangeValidator.class);
        double min = rv.minValue();
        double max = rv.maxValue();   
        
        // Determine the data type of this field
        String type = field.getType().toString();
        
        if(type.endsWith("int")){       
            int num = field.getInt(this);
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }        
        else if(type.endsWith("byte")){        
            byte num = field.getByte(this);
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }
        else if(type.endsWith("short")){
            short num = field.getShort(this);
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }
        else if(type.endsWith("long")){        
            long num = field.getLong(this);
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }        
        else if(type.endsWith("float")){        
            float num = field.getFloat(this);
            min = (float)min;
            max = (float)max;
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }  
        else if(type.endsWith("double")){        
            double num = field.getDouble(this);
            if (!(num >= min && num <= max)){
                addRangeError(field.getName(),min,max);
            }
        }                  
    }
        
    private String formatName(String fieldName){
        
        // Returns the name of the property formatted
        // e.g. firstName would be returned as 'First Name'.
        
        byte len = (byte)fieldName.length();
        StringBuilder sb = new StringBuilder();
        
        for(byte i = 0 ; i < len ; i++){
            
            if(i==0){
                sb.append(fieldName.substring(0, 1).toUpperCase());                
            }
            else if (Character.isUpperCase(fieldName.charAt(i))){
                sb.append(" ");
                sb.append(fieldName.charAt(i));
            } else {
                sb.append(fieldName.charAt(i));
            }
            
        }
        
        return sb.toString();        
    }
    
    // </editor-fold> 

}
