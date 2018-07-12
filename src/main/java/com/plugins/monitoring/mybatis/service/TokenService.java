package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/3 09:02
 * @Description: token
 */

@Service
public class TokenService {
    @Autowired
    private TokenMapper tokenMapper;

    public Token getToken(String id) {
        return tokenMapper.getToken( id );
    }

    public int insert(Token token) {
        return tokenMapper.insert( token );
    }

    public void update(Token id) {
        tokenMapper.update( id );
    }

    public void delete(Token id) { tokenMapper.delete( id ); }
}
