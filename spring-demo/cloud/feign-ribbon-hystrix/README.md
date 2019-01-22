# spring-demo: feign, ribbon, hystrix
运行test步骤：<br>
1. 运行eureka-server<br>
2. 运行多个eureka-clint实例<br>
3. 执行本项目test<br>
4. 运行项目，HystrixDashboard：http://host:port/hystrix<br>
5. 监控数据：http://host:port/actuator/hystrix.stream<br>
6. rest.invoke-simulator=ture开启线程随机发请求产生dashboard数据<br>
![avatar](res/hystrixDashboard.jpg) 
## 说明
openfeign依赖ribbon做lb，需要ribbon的starter依赖；<br>
使用eureka时，服务发现需要引入eureka-client依赖；
