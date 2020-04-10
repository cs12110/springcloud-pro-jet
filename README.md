# spring cloud 

Spring cloud项目的Hello world.

大神请绕路,谢谢. 微笑脸.jpg

---

## 1. 项目结构

| 模块名称         | 端口 | 备注          |
| ---------------- | ---- | ------------- |
| pro-jet-center   | 7000 | 注册中心      |
| pro-jet-gateway  | 8000 | 网关          |
| pro-jet-business | 7100 | business 模块 |
| pro-jet-order    | 7200 | order 模块    |
| pro-jet-common   | -    | 公共模块      |
| pro-jet-feign    | -    | feign         |


项目开启步骤: `pro-jet-center` -> `pro-jet-gateway` -> `pro-jet-business` -> `pro-jet-order`.

---

## 2. issues

记录项目模块相关功能.

### 2.1 feign使用httpclient

在feign里面使用`httpclient`.网上的教程都有开启一个玩意的,但是在`Finchley`版本里面的feign配置类

```java
@Configuration
@ConditionalOnClass(ApacheHttpClient.class)
@ConditionalOnProperty(value = "feign.httpclient.enabled", matchIfMissing = true)
class HttpClientFeignLoadBalancedConfiguration {
    //...
}
```
可以看出来只要有`ApacheHttpClient`的依赖,不用配置那个配置项也是可以生效.

