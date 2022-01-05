package com.yyfolium.springbootrestserver.testuse;

import com.yyfolium.springbootrestserver.testtest.aService;
import com.yyfolium.springbootrestserver.testtest.bService;
import com.yyfolium.springbootrestserver.testtest.printInterface;

class testController {

  printInterface setService(int age) {
    printInterface service = null;
    if (age > 22) {
      service = new aService();
    } else {
      service = new bService();
    }
    return service;
  }
}
