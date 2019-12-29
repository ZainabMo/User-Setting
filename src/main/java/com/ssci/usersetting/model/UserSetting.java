package com.ssci.usersetting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection="user-settings")
public class UserSetting {

  @Id
  private String id;

  private String currency;
  private int scale;
  private int decimal;
  private String landingPage;
  private String userId;

  public UserSetting() {}

  public UserSetting(String currency, String landingPage, int scale, int decimal, String userId) {
    this.currency = currency;
    this.landingPage = landingPage;
    this.userId = userId;
    this.decimal = decimal;
    this.scale = scale;
  }

  @Override
  public String toString() {
    return String.format(
        "UserSetting[id=%s, currency='%s', landing_page='%s', user_id='%s']",
        id, currency, landingPage, userId);
  }

}