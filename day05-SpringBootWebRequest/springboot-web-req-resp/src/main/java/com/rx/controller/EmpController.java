package com.rx.controller;

import com.rx.pojo.Emp;
import com.rx.pojo.Result;
import com.rx.service.EmpService;
import com.rx.service.impl.EmpServiceA;
import com.rx.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.VarHandle;
import java.util.List;

//@Controller
@RestController
public class EmpController {

    @Autowired //运行时，ioc容器会提供该类的类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list() {

        //调用service，获取数据
        List<Emp> empList=empService.listEmp();

        return Result.success(empList);

        /*//1、加载并解析emp.xml
                //String file="D:\\Java-codes\\javaweb_rearend\\day05-SpringBootWebRequest\\springboot-web-req-resp\\src\\main\\resources\\emp.xml"
                String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
                System.out.println(file);
                List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

                //2、对数据进行转换处理 - gender, job

                //处理 gender 1: 男, 2: 女
                empList.stream().forEach(emp -> {
                    String gender = emp.getGender();
                    if ("1".equals(gender)) {
                        emp.setGender("男");
                    } else if ("2".equals(gender)) {
                        emp.setGender("女");
                    }

                    //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
                    String job = emp.getJob();
                    if ("1".equals(job)) {
                        emp.setJob("讲师");
                    } else if ("2".equals(job)) {
                        emp.setJob("班主任");
                    } else if ("3".equals(job)) {
                        emp.setJob("就业指导");
                    }
                });
        */

        //3. 响应数据
        //return Result.success(empList);

    }

}
