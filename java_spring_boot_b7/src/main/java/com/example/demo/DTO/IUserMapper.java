package com.example.demo.DTO;

import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    //@Mapping()
    UserInfo userToUserInfo(User user);
}
