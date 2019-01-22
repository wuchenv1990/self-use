# config-server
1. 运行config center，配置文件为本地<br>
2. bootstrap.yml中进行配置：<br>
    - spring.profiles.active=native 表示本地配置文件
    - search-locations: classpath:/config 搜索配置文件位置
