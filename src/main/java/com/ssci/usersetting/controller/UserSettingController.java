package com.ssci.usersetting.controller;

import java.util.List;

import com.ssci.usersetting.model.UserSetting;
import com.ssci.usersetting.model.UserSettingVO;
import com.ssci.usersetting.service.UserSettingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSettingController {
  
  private UserSettingService userSettingService;

  public UserSettingController(UserSettingService userSettingService){
    this.userSettingService = userSettingService;
  }


  @RequestMapping("/user-setting/count")
  public long getUserSettingCount() {
    return userSettingService.getCount();
  }
  //find all
  @RequestMapping("/user-setting")
  public List<UserSetting> getUserSettings() {
    return userSettingService.findAll();
  }

  //find by currency
  @RequestMapping(value = "/user-setting", params = "currency")
  public List<UserSetting> getUserSettingCurr(@RequestParam(value="currency") String currency) {
    return userSettingService.findByCurrency(currency);
  }
  
  //find by user id
  @RequestMapping(value = "/user-setting", params ="userId")
  public List<UserSetting> getUserSettingUserId(@RequestParam(value="userId") String userId) {
    return userSettingService.findByUserId(userId);
  }

  //find by id
  @RequestMapping(value = "/user-setting/{id}", method = RequestMethod.GET)
  public UserSetting getUserSettingId(@PathVariable String id) {
    return userSettingService.findById(id);
  }

  @PostMapping(value="/user-setting")
  public UserSetting addUserSetting(@RequestBody UserSettingVO userSettingVO){
    return userSettingService.addUserSetting(userSettingVO);
  }
  
  @PutMapping(value="/user-setting/{id}")
  public UserSetting updateUserSetting(@PathVariable String id, @RequestBody UserSettingVO userSettingVO){
    return userSettingService.updateUserSetting(id, userSettingVO);
  }
  
  @PatchMapping(value="/user-setting/{id}")
  public UserSetting updateSomeUserSetting(@PathVariable String id, @RequestBody UserSettingVO userSettingVO){
    return userSettingService.updateUserSetting(id, userSettingVO);
  }

  //delete w id
  @DeleteMapping(value="/user-setting/{id}")
  public void deleteUserSetting(@PathVariable String id){
    userSettingService.deleteUserSetting(id);
  }
  
}