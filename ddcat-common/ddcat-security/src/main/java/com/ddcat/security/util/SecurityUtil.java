package com.ddcat.security.util;

import com.ddcat.security.entity.UserBean;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author dd-cat
 */
@UtilityClass
public class SecurityUtil {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户
     */
    public UserBean getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    public UserBean getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserBean) {
            return (UserBean) principal;
        }
        return null;
    }


}
