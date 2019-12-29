package com.ssci.usersetting.repository;

import java.util.List;

import com.ssci.usersetting.model.UserSetting;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSettingRepository extends MongoRepository<UserSetting, String> {

  public List<UserSetting> findByUserId(String userId);
  public List<UserSetting> findByCurrency(String landingPage);
  public long count();

}
