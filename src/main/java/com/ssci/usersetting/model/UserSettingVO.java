package com.ssci.usersetting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection="user-settings")
public class UserSettingVO {

  @Id
  private String id;
  
  private String currency;
  private String scale;
  private String decimal;
  private String landingPage;
  private String userId;

  public UserSettingVO() {}

  public UserSettingVO(String currency, String landingPage, String scale, String decimal, String userId) {
    this.currency = currency;
    this.landingPage = landingPage;
    this.userId = userId;
    this.decimal = decimal;
    this.scale = scale;
  }

  @Override
  public String toString() {
    return String.format(
        "UserSetting[id=%s, currency='%s', landing_page='%s', user_id='%s', scale='%s', decimal='%s']",
        id, currency, landingPage, userId, scale, decimal);
  }

}