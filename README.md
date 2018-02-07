# spring-cloud-action
在微服务架构中，需要几个基础的服务治理组件，包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，由这几个基础组件相互协作，共同组建了一个简单的微服务系统。一个简答的微服务系统如下图：
![image_1c5ni0c53lnm1jaqdo6108j1dqc30.png-81.1kB][1]
## spring-cloud-parent
通用的依赖
## spring-cloud-eureka
服务治理：eureka使用
服务消费、负载均衡：ribbon、feign 使用
熔断器：hystrix 使用
## spring-cloud-zuul
api网关：zuul使用

  [1]: http://static.zybuluo.com/swellwu/l7kewm3ns36zf4c1qkmlsw83/image_1c5ni0c53lnm1jaqdo6108j1dqc30.png

