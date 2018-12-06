
import javax.swing.text.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbstk
 */
public class Limit extends PlainDocument{
    private int limit;
    
    public Limit(int limit){
        super();
        this.limit = limit;
    }
    
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException 
    {
        if (str == null)
            return;

        if (getLength() + str.length() <= limit) 
            super.insertString(offset, str, attr);
    }
    
   
}
