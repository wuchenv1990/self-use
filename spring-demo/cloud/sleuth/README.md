# sleuth
1. 运行zipkin-server：<br>
https://github.com/openzipkin/zipkin/tree/master/zipkin-server<br>
参见quick-start，完成后可访问http://localhost:9411/zipkin/
2. sleuth工程引入依赖spring-cloud-starter-zipkin，调用的其余服务也同样引入并配置
3. sleuth增加到f-r-h和eureka-client的rest调用
4. 启动后可以按[1]中的地址看到效果
