package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.exception.AppExceptionCodeMsg;
import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.dto.UserDTO;
import com.countervalorantapex.contractmanagement.sys.dto.UserNameDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.service.IUsersService;
import com.countervalorantapex.contractmanagement.sys.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.countervalorantapex.contractmanagement.sys.utils.AESUtils.encrypt;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/sys/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUsersService iUsersService;
    public UsersController(IUsersService userService) {
        this.iUsersService = userService;
    }

    @GetMapping("/{userAccount}")
    public ResponseEntity<?> getUserByAccount(@PathVariable String userAccount) {
        Users user = iUsersService.getUserByAccount(userAccount);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public Resp<String> login(@RequestParam("identifier") String identifier, @RequestParam("password") String password) {
        Users user = iUsersService.login(identifier, password);
        UserDTO userDTO = new UserDTO();
        if (user != null) {
//            String token = JwtUtil.generateToken(user.getUserAccount(), 30);
            String token = TokenUtils.genToken(identifier);
            userDTO.setUserName(user.getUserName());
            userDTO.setUserAccount(user.getUserAccount());
            userDTO.setUserRole(user.getUserRole());
            userDTO.setToken(token);
            return Resp.success(userDTO);
        } else {
            return Resp.error(AppExceptionCodeMsg.USER_NOT_EXISTS);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        try {
            user.setUserPassword(encrypt(user.getUserPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            iUsersService.register(user);
            return new ResponseEntity<>("用户注册成功", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("注册失败，请重试", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/userName")
    public List<UserNameDTO> getUserNames() {
        List<Users> names = iUsersService.getUserNames();
        List<UserNameDTO> dtos = new ArrayList<>();

        for (Users name : names) {
            // 只提取 user_role 值为 2 的用户名
            if (name.getUserRole() == 2) {
                UserNameDTO dto = new UserNameDTO(name.getUserName());
                dtos.add(dto);
            }
        }

        return dtos;
    }


}
