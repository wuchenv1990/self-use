# clouded-out
支持ANSI颜色控制：<br>
"\033[背景色;颜色;样式m字符串\033[0m"<br>
该项目scope是provided，利用springboot应用中的控制颜色、样式实现，调试时方便打出自定义颜色文字小工具。<br>
## 使用方式
方便自定义修改，如输出红色：<br>
```java
ColoredOut.RED.println(s);
```
