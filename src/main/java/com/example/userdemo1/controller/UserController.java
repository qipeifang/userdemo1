package com.example.userdemo1.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.userdemo1.entity.TUser;
import com.example.userdemo1.security.SHA1Test;
import com.example.userdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *根据条件查询用户信息
     * @param kw 查询关键字即条件
     * @param modelMap 模型对象，也是视图（界面）的上下文环境对象
     * @param page 分当前页码
     * @param size 每页的数据
     * @return 字符串，代表了界面文件
     */
    @RequestMapping("/listusers")
    public String listall(String kw, ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size){
        Page<TUser> datas = userService.findBookNoCriteria(page, size);
        modelMap.addAttribute("datas", datas);
        return "listusers";
    }

    @RequestMapping(value = "/listusers",method = {RequestMethod.GET,RequestMethod.POST})
    public String listuserbykw(String kw, ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "5") Integer size){
        modelMap.addAttribute("kw",kw);
        if (kw!=null) kw="%"+kw+"%";
        if (kw==null) kw="%%";
        Page<TUser> datas=userService.findBookCriteria(page, size,kw);//默认分页从0页面（第一页），取每页20条数据
        modelMap.addAttribute("datas", datas);
        return "listusers";//返回界面
    }

    /**
     * edituser 添加用户
     * edituser/{id} 修改用户id的信息
     * name="id",required = false -->id不是必须的
     * @param id
     * @param model
     * @return
     */
    @GetMapping({"/edituser","/edituser/{id}"})
    public String edit(@PathVariable(name="id",required = false)Integer id, Model model,String email) {
        TUser u = new TUser();
        if (id != null && id > 0) {//即路径为edituser/{id}  编辑用户
            u = userService.findById(id);
        }
        model.addAttribute("sexes",TUser.Sex.toList());
        model.addAttribute("user", u);
        return "edituser";
    }
    @PostMapping("/saveuser")
    public String save(@Valid TUser user, BindingResult result, RedirectAttributes attr){
        try {
            if(result.hasErrors()){
                System.out.println(result.getFieldError().toString());
                return "redirect:/edituser";
            }
            //如果id为0 jpa的save方法起新增的作用;如果save不为0 那么jpa save方法起update作用
            if (user.getId()==0){
                //检查邮箱是否已注册
                if(userService.findEmail(user.getEmail()).size()!=0){
                    attr.addFlashAttribute("message","该邮箱已注册");
                    return "redirect:/edituser";
                }
                //密码加密
                SHA1Test sha1Test = new SHA1Test();
                user.setPassword(sha1Test.toHexString(user.getPassword()));
            }
            userService.save(user);
            attr.addFlashAttribute("ok","保存成功");
            return "redirect:/listusers";
        }catch (Exception ex){
            return "redirect:/edituser";
        }

    }

    @GetMapping("/deleteuser/{id}")
    public String delete(@PathVariable("id")Integer id){
        userService.deleteById(id);
        return "redirect:/listusers";
    }

    @PostMapping("/deleteusers")
    public String deletes(String ids){
        System.out.println("======"+ids);
        List<TUser> users=new ArrayList<>();
        JSONObject json=JSONObject.parseObject(ids);
        JSONArray arr=json.getJSONArray("ids");//前端传递时使用uods作为json数据的键
        int ilen=arr.size();
        for (int i=0;i<ilen;i++){//每次循环ilen次来执行ilen个查询，再去删除
            users.add(userService.findById(arr.getInteger(i)));
        }
        userService.deletes(users);
        return "redirect:/listusers";

    }
}
