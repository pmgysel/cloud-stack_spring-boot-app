package com.example.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRestController {

  @Autowired
  BuildProperties buildInfo;

  @RequestMapping(method = RequestMethod.GET, path = "/api/ping")
  public ResponseEntity<String> getPing() {
    return ResponseEntity.ok("Hello world, here is " + buildInfo.getName() + " version " + buildInfo.getVersion());
  }

}
