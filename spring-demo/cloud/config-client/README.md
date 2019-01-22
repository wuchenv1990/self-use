# config-client
1. 单独创建一个module做config-client示例，以及测试config center<br>
2. bootstrap文件配置对应config-server的配置文件名，规则如下：<br>
    - /{application.name}/{profile}[/{label}]
    - /{application.name}}-{profile}.yml
    - /{label}/{application.name}}-{profile}.yml
    - /{application.name}}-{profile}.properties
    - /{label}/{application.name}}-{profile}.properties
3. run junit，根据profile测试配置文件值，也可通过rest查看
