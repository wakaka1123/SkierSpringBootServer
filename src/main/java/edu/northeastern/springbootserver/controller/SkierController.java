package edu.northeastern.springbootserver.controller;

import com.google.gson.Gson;
import edu.northeastern.springbootserver.entities.LiftRide;
import edu.northeastern.springbootserver.entities.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skiers")
public class SkierController {

  private static final String CREATED = "Write successfully";
  private static final String BAD_REQUEST = "Invalid URL";

  @GetMapping(value = "/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}", produces = "application/json")
  public String doGet() {
    return "Url works!";
  }

  @GetMapping(value = "/seasons")
  public String doGetAll() {
    return "Api works!";
  }

  @PostMapping(value = "/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}", produces = "application/json")
  public ResponseEntity<Object> doPost(
      @PathVariable int resortID,
      @PathVariable String seasonID,
      @PathVariable String dayID,
      @PathVariable int skierID,
      @RequestBody LiftRide body
  ) {
    Gson gson = new Gson();
    if (isValidUrl(resortID, seasonID, dayID, skierID) && isBodyValid(body)) {
      return new ResponseEntity(gson.toJson(new ResponseMessage(CREATED)), HttpStatus.CREATED);
    } else {
      return new ResponseEntity(gson.toJson(new ResponseMessage(BAD_REQUEST)),
          HttpStatus.BAD_REQUEST);
    }
  }

  private boolean isValidUrl(int resortID, String seasonID, String dayID, int skierID) {
    return resortID > 0 && !seasonID.isEmpty() && !dayID.isEmpty() && skierID > 0;
  }

  private boolean isBodyValid(LiftRide body) {
    return body != null && body.getTime() > 0 && body.getLiftID() > 0;
  }


}
