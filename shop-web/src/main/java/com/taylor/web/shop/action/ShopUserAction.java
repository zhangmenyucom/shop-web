package com.taylor.web.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taylor.api.shop.entity.ShopUser;
import com.taylor.api.shop.service.ShopUserService;

/**
 * @ClassName: ShopUserAction
 * @Function: 用户控制层.
 * @date: 2016年4月18日 上午1:24:55
 * @author Taylor
 */
@Controller
@RequestMapping("/user/*")
public class ShopUserAction {
    private static final Logger LOGGER = Logger.getLogger(ShopUserAction.class);

    @Autowired
    private ShopUserService shopUserService;

    /**
     * @desc userAcount(查询用户数量)
     * @author taylor
     * @date 2016年4月18日 上午1:29:31
     */
    @RequestMapping("user_count")
    public String userCount(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer count = shopUserService.countShopUsers();
            ShopUser shopUser = new ShopUser();
            shopUser.setId(1);
            shopUser = shopUserService.queryShopUser(shopUser);
            map.put("user_count", count);
            map.put("shopUser", shopUser);
        } catch (Exception e) {
            LOGGER.error("调用shopUserAction.userCount出错", e);
        }
        return "user/user_count";
    }
}
