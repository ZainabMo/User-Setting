package com.ssci.usersetting.service;

import java.util.List;

import com.ssci.usersetting.model.UserSetting;
import com.ssci.usersetting.model.UserSettingVO;
import com.ssci.usersetting.repository.UserSettingRepository;

import org.springframework.stereotype.Service;

@Service
public class UserSettingService{

    private UserSettingRepository repository;
    public UserSettingService (UserSettingRepository repository){
        this.repository = repository;
    }
    public long getCount(){
        //repository.save(new UserSetting("US", "abc.com",2,2,"user1"));
        //repository.save(new UserSetting("EURO", "efg.com",2,2,"user2"));
        //List <UserSetting> userSetting = repository.findAll();
        return repository.count();
    }
    public List<UserSetting> findAll(){
        return repository.findAll();
    }
    public List<UserSetting> findByCurrency(String curr){
        return repository.findByCurrency(curr);
    }
    public List<UserSetting> findByUserId(String uId){
        return repository.findByUserId(uId);
    }
    public UserSetting findById(String id){
        return repository.findById(id).get();
    }
    public UserSetting addUserSetting(UserSettingVO userSettingVO){
        UserSetting userSetting = new UserSetting();
        convertUserSetting(userSettingVO, userSetting);
        return repository.save(userSetting);
    }
    public UserSetting updateUserSetting(String id, UserSettingVO userSettingVO){  
        UserSetting userSetting = findById(id);
        convertUserSetting(userSettingVO, userSetting);
        return repository.save(userSetting);
    }
    public void deleteUserSetting(String id){
        UserSetting userSetting = findById(id);
        repository.delete(userSetting);
    }
    private void convertUserSetting(UserSettingVO userSettingVO, UserSetting userSetting){
        if(userSettingVO.getCurrency() != null){
            userSetting.setCurrency(userSettingVO.getCurrency());
        }
        if(userSettingVO.getScale() != null){
            userSetting.setScale(Integer.parseInt(userSettingVO.getScale()));
        }
        if(userSettingVO.getDecimal() != null){
            userSetting.setDecimal(Integer.parseInt(userSettingVO.getDecimal()));
        }
        if(userSettingVO.getLandingPage() != null){
            userSetting.setLandingPage(userSettingVO.getLandingPage());
        }
        if(userSettingVO.getUserId() != null){
            userSetting.setUserId(userSettingVO.getUserId());
        }
    }
}