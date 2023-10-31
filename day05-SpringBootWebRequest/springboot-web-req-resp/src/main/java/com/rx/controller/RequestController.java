package com.rx.controller;

import com.rx.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*测试请求参数接收*/
@RestController
public class RequestController {

    //1、简单参数
   /* @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return "OK";
    }*/

    //1、简单参数
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age) {
        //@RequestParam中的request默认为true，此时参数必须传递
        System.out.println(username + ":" + age);
        return "OK";
    }

    //2、实体参数
    @RequestMapping("simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "OK";
    }

    //3、复杂参数
    @RequestMapping("complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK";
    }

    //3、数组参数、集合参数
    @RequestMapping("arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    /*在 arrayParam 方法中不使用 @RequestParam 注解，而在 listParam 方法中使用 @RequestParam 注解，主要是因为这两个方法处理请求参数的方式不同。

arrayParam 方法：

参数类型是 String[]，表示它期望将请求参数与该数组一对一地绑定。Spring会尝试将请求参数的值映射到 String[] hobby，其中参数名称 "hobby" 与数组的元素一一对应，无需显式指定参数名称，因此不需要 @RequestParam 注解。
listParam 方法：

参数类型是 List<String>，这表示它期望将请求参数与列表一对多地绑定。Spring需要明确知道应该将请求中的参数值绑定到哪个参数，因为参数类型是列表，而不是单个值。这就是为什么在 listParam 方法中使用 @RequestParam 注解，并指定参数名称 "hobby"，以明确告诉Spring将请求参数 "hobby" 的值绑定到 List<String> hobby 中。
总结：

arrayParam 方法期望请求参数的名称与数组的元素一一对应，所以不需要 @RequestParam。
listParam 方法期望将多个请求参数的值收集到一个列表中，因此需要使用 @RequestParam 来明确指定参数名称。*/

    //4、时间日期参数
        @RequestMapping("dateParam")
        public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
            System.out.println(updateTime);
            return "OK";
        }

    //5、json参数
    @RequestMapping("jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    //6、路径参数
    @RequestMapping("path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name) {
        System.out.println(id+":"+name);
        return "OK";
    }

}