package com.example.sercuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//类级别映射，可以没有，一般用于减少书写量
@RequestMapping("/product")
public class ProductTestController {

    //方法级别映射，必须有，那么这个方法的访问地址就是/info/aaa，请求到的页面就是test.jsp【当然，这里的.jsp需要在配置文件中配置】
    @RequestMapping("/info")
    /*  @ResponseBody是作用在方法上的，@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，
        一般在异步获取数据时使用【也就是AJAX】，在使用 @RequestMapping后，返回值通常解析为跳转路径，
        但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。
        比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据。@RequestBody 将 HTTP 请求正文插入方法中，
        使用适合的 HttpMessageConverter 将请求体写入某个对象。
    */
    @ResponseBody
    public String productInfo(){
        return "some product info ";
    }

}
