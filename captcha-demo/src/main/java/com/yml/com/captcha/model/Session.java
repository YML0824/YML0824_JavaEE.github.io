package com.yml.com.captcha.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-22
 * Time: 13:48
 * session放在这里可以不用加static
 */

@Data
public class Session {
        private String key;
        private String date;
}
