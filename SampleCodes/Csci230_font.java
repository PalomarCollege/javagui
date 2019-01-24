/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

/*
*
* Purpose: 1) Demostrate to list the font names of the local Graphics environment 
*/

package csci230_font;

import java.awt.GraphicsEnvironment;

public class Csci230_font {

  public static void main(String[] args)
  {
    String fonts[] = 
      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    for (String font:fonts)
    {
      System.out.println(font);
    }
  }
    
}

