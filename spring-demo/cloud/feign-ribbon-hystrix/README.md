# spring-demo: feign, ribbon, hystrix
运行test步骤：<br>
1、运行eureka-server<br>
2、运行多个eureka-clint实例<br>
3、执行本项目test<br>
## 说明
openfeign依赖ribbon，只用feign时需要ribbon的starter依赖；<br>
使用eureka，服务发现需要引入eureka-client依赖；
