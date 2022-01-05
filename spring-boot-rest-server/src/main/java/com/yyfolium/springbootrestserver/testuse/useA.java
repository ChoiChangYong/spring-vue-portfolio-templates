package com.yyfolium.springbootrestserver.testuse;

import com.yyfolium.springbootrestserver.testtest.printInterface;
import com.yyfolium.springbootrestserver.testuse.testController;

public class useA {

  private testController tc = new testController();
  private printInterface as;
  private int age;

  public useA() {
    this.age = 22;
  }

  public void use() {
    as = tc.setService(age);
    System.out.println(as.printB()); // b
  }
}
