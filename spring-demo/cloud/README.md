# spring-demo-cloud
spring-cloud相关<br>
## 项目搭建说明
由于边学习边搭建，模块名和功能不一定合理，因此按时间顺序说明如下。一些注释在代码中。
### 1、eureka-server
简单版注册中心。
### 2、eureka-client
应用作为eureka-client，即服务发布，通过rest提供api<br>
全局异常抛出的500为测试feign熔断<br>
### 3、feign-ribbon-hystrix
1. 先后实现feign、ribbon客户端对[2]中eureka-client的调用；
2. 引入hystrix的feign、ribbon支持；
3. 开启hystrixDashboard
### 4、增加sleuth
增加使用zipkin的sleuth工程，实现链路追踪，并为[2]和[3]添加sleuth支持
### 5、增加config-server/client
client的@Value注入从server中获取

## 附cloud与boot对应关系：
Release Train | Boot Version
| - | - |
Greenwich | 2.1.x
Finchley | 2.0.x
Edgware | 1.5.x
Dalston | 1.5.x
