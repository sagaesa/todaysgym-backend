package com.sagaesa.user;

import com.sagaesa.user.dto.PostLoginReq;
import com.sagaesa.user.dto.PostSignupReq;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody PostSignupReq postSignupReq) {
        return new ResponseEntity(userService.create(postSignupReq), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody PostLoginReq postLoginReq) {
        return new ResponseEntity(userService.login(postLoginReq), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("")
    public ResponseEntity getProfile(@RequestParam("userId") Long userId) {
        return new ResponseEntity(userService.getProfile(userId), HttpStatus.OK);
    }

}
