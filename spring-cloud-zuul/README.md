# spring-cloud-zuul
zuul：api-gateway
Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
## 依赖
```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zuul</artifactId>
    </dependency>
```
## 配置
eg:
```yaml
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: service-ribbon
    api-b:
      path: /api-b/**
      serviceId: service-feign
```
表示/api-a/** 路由到eureka上service-ribbon的service上
表示/api-b/** 路由到eureka上service-feign的service上
## 启动
依次启动 eureka-server、eureka-cli、service-feign、service-ribbon、service-ribbon
然后访问 
http://127.0.0.1:8769/api-a/hi?name=swellwu
http://127.0.0.1:8769/api-b/hi?name=swellwu
即可看到路由效果：
![image_1c5nqv9er17no96adk81a4f15jip.png-15.6kB][1]

 [1]: http://static.zybuluo.com/swellwu/zfbsh3s6u91m2eju11y13w9i/image_1c5nqv9er17no96adk81a4f15jip.png