package com.kep.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kep.springboot.common.Constants;
import com.kep.springboot.controller.dto.UserDTO;
import com.kep.springboot.entity.User;
import com.kep.springboot.exception.ServiceException;
import com.kep.springboot.mapper.UserMapper;
import com.kep.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kep.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kp
 * @since 2022-02-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one !=null) {
            BeanUtil.copyProperties(one,userDTO,true);
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }

    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null){
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            save(one);  //把copy之后的用户对象存储到数据库
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在！");
        }
        return one;
    }

    private User getUserInfo(UserDTO userDTO){  //封装一个查询检测方法
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
//        第一种方式，后台查询出多条相同的账号
//        List<User> list = list(queryWrapper);
//        return list.size()!=0;
//        第二种方式
        try{
            one = getOne(queryWrapper);    //从数据库查询用户信息

        }catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }
}
