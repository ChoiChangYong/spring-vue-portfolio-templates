package com.yyfolium.springbootrestserver.testuse;

import com.yyfolium.springbootrestserver.testtest.bService;
import com.yyfolium.springbootrestserver.testtest.printInterface;

public class useA2 {

  private testController tc = new testController();
  private printInterface as;
  private int age;

  public useA2() {
    this.age = 24;
  }

  public void use() {
    as = tc.setService(age);
    System.out.println(as.printA()); // a
  }
}
