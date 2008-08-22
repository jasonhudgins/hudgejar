package net.spy.jutils;

public class SQL {
  public static String quoteString(String s) {
    
    String retvalue = s;
    
    // if it's null, just return an empty string.
    if (s == null) {
      retvalue = "";
    }
    
    if (s != null && s.indexOf ("'") != -1 ) {
      StringBuffer hold = new StringBuffer();
      char c;
      for (int i=0; i < s.length(); i++ ) {
        if ((c=s.charAt(i)) == '\'' ) {
          hold.append ("''");
        }
        else {
          hold.append(c);
        }
      }
      retvalue = hold.toString();
    }
    return retvalue;
  }
}
