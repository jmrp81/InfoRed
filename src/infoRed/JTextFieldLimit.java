package infoRed;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Clase para limitar tamaño de los JTextField
 * @version 2013
 * @serial 1.0
 * @author Juan Manuel / Abraham Lopez
 */
public class JTextFieldLimit extends PlainDocument {  
          private int limit;  
          private boolean toUppercase = false;  
            
          JTextFieldLimit(int limit) {  
           super();  
           this.limit = limit;  
           }  
           
          @Override
          public void insertString  
            (int offset, String  str, AttributeSet attr)  
              throws BadLocationException {  
           if (str == null) return;  
  
           if ((getLength() + str.length()) <= limit) {  
             if (toUppercase) str = str.toUpperCase();  
             super.insertString(offset, str, attr);  
             }  
           }  
        } 
