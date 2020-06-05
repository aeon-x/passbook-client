package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.Pass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>用户优惠券服务测试</h1>
 * Created by Qinyi.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPassServiceTest extends AbstractServiceTest {

    @Autowired
    private IUserPassService userPassService;

// {"data":[
//  {"merchants":
//      {"address":"sg","businessLicenseUrl":"www.imooc.com","id":18,"isAudit":true,"logoUrl":"www.imooc.com","name":"test1","phone":"1234567890"},
//  "pass":
//      {"assignedDate":1578067200000,"rowKey":"3597219223370445580121163be79b689fbacf0906e66cbf347234ae9","templateId":"be79b689fbacf0906e66cbf347234ae9","token":"token-2","userId":127953},
//  "passTemplate":
//      {"background":2,"desc":"bbb","end":1592064000000,"hasToken":true,"id":18,"limit":9997,"start":1590336000000,"summary":"aaa","title":"test3"}}],
//  "errorCode":0,"errorMsg":""}

    @Test
    public void testGetUserPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(
                userPassService.getUserPassInfo(userId))
        );
    }

    // {"data":[],"errorCode":0,"errorMsg":""}
    @Test
    public void testGetUserUsedPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(
                userPassService.getUserUsedPassInfo(userId)
        ));
    }

    @Test
    public void testGetUserAllPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(
                userPassService.getUserAllPassInfo(userId)
        ));
    }

    // {"errorCode":0,"errorMsg":""}

    @Test
    public void testUserUsePass() {

        Pass pass = new Pass();
        pass.setUserId(userId);
        pass.setTemplateId("be79b689fbacf0906e66cbf347234ae9");

        System.out.println(JSON.toJSONString(
                userPassService.userUsePass(pass)
        ));
    }
}
