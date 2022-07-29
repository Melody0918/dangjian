package com.kep.springboot.service;

import com.kep.springboot.controller.dto.UserDTO;
import com.kep.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kp
 * @since 2022-02-09
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
