package com.hnu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data  //@Data 可自动配get，set方法
public class User {

    private String username;
    private String password;

}
