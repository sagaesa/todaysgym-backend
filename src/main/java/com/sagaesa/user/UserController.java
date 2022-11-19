package com.sagaesa.user;

import com.sagaesa.user.dto.PostSignupReq;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    /*
    @ResponseBody
    @PostMapping("")
    public PostSignupReq signup(@RequestBody PostSignupReq postSignupReq) {

        Long userId = userService.createUser(postSignupReq);
        return ;
    }
    */

}
