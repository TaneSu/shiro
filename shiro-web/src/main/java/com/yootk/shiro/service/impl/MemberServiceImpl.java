package com.yootk.shiro.service.impl;

import com.yootk.shiro.service.IMemberService;
import com.yootk.shiro.util.DatabaseConnection;
import com.yootk.shiro.vo.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberServiceImpl implements IMemberService {
    @Override
    public Member get(String mid) {
        Member member = null ;
        try {
            String sql = "SELECT mid,name,password,locked FROM member WHERE mid=?" ;
            PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,mid);
            ResultSet rs = pstmt.executeQuery() ;
            if (rs.next()) {
                member = new Member() ;
                member.setMid(rs.getString(1));
                member.setName(rs.getString(2));
                member.setPassword(rs.getString(3));
                member.setLocked(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close();
        }
        return member;
    }
}
