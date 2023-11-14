package com.rx.controller;

import com.rx.aop.MyLog;
import com.rx.mapper.DeptMapper;
import com.rx.pojo.Dept;
import com.rx.pojo.Result;
import com.rx.service.DeptService;
import com.rx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  部门管理Controller
 */

@Slf4j
@RequestMapping("/depts") //公共请求路径
@RestController //1、用于接受web请求
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired //3、注入service对象，用于接受service数据
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)

    @GetMapping//2、确定响应地址，根据地址调用函数，实现功能
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList=deptService.list(); //9、接受service的list函数返回的Dept集合

        return Result.success(deptList); //10、将得到的的Dept集合返回至web
    }

    @MyLog
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        deptService.delete(id);

        return Result.success();
    }

    @MyLog
    @PostMapping
    public Result add(@RequestBody Dept dept){ //RequestBody将request的json转为实体类给后端
        log.info("新增部门:{}",dept.getName());

        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询部门:{}",id);

        Dept dept=deptService.selectById(id);
        return Result.success(dept);

    }

    @MyLog
    @PutMapping
    public Result edit(@RequestBody Dept dept){
        log.info("根据id修改部门:{}",dept.getName());

        deptService.edit(dept);
        return Result.success();
    }

}
