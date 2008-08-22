package net.spy.jutils;

import junit.framework.TestCase;

public class SQLTests extends TestCase {

  // this is a method to test the quote functionality.
  public void testQuoteString() throws Exception {
    assertEquals("jon''s cat is black", SQL.quoteString("jon's cat is black"));
  }
  
  public void testNullQuoteString() throws Exception {
    assertEquals("", SQL.quoteString(null));
  }
}
