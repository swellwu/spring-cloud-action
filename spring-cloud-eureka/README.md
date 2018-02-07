# spring-cloud-eureka
## eureka 服务治理
eureka 依赖：
```xml
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Edgware.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    <dependencies>
        <!-- eureka -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
    </dependencies>
```

先启动eureka-server，再启动eureka-client
访问eureka管理页面：http://localhost:8761/
可以看到client已经注册：
![eureka管理页面][1]
通过eureka调用服务：
http://localhost:8762/hi?name=swellwu
可以看到调用服务成功：
![调用服务][2]
## 服务消费者
### 服务消费者ribbon 
ribbon+restTemplate 提供负载均衡
启动eureka-server 和 两个eureka-client，相当于一个服务有多个提供者。
然后启动service-ribbon，访问http://localhost:8764/hi?name=swellwu
实现了负载均衡
如图：
![image_1c5n591841uiu1b0pl0d1mne10uh9.png-12.6kB][3]

![image_1c5n59pc91cvb1kmfo3g144d1h8u1m.png-12.3kB][4]

### 服务消费者feign
内部用ribbon实现，使用注解的方式实现服务消费

## 断路器 hystrix
在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。
默认5s失败20次开启熔断
### ribbon
Application开启hystrix
```java
@EnableHystrix
```
设置熔断方法
```java
    /**
     * 设置熔断方法为 hiError
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
```
### feign
使用注解指定熔断方法
```
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
```
## hystrix dashboard
以feign为例
依赖：
```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
    </dependency>
```
Application上开启hystrix dashboard：
```
@EnableHystrixDashboard
```
启动feign后，访问web：http://localhost:8765/hystrix
即可访问hystrix dashboard：
![image_1c5nhgn23rcs1uhc1qrs18k913d72j.png-117.2kB][5]

[1]: http://static.zybuluo.com/swellwu/fxewcjnkl0z43beqqs9nj5w9/image_1c5lnsm75119m6tdlnrjv52ikp.png
[2]: http://static.zybuluo.com/swellwu/uos4iji7wqadnsizlv4f002o/image_1c5lo1mkucmbpag1f6618r01rcs1m.png
[3]: http://static.zybuluo.com/swellwu/cs7ug73y2q8b7j02jkcacxxy/image_1c5n591841uiu1b0pl0d1mne10uh9.png
[4]: http://static.zybuluo.com/swellwu/ulcxo4z7q8h1w80c488cu581/image_1c5n59pc91cvb1kmfo3g144d1h8u1m.png
[5]: http://static.zybuluo.com/swellwu/pky2pteu0dnlp704t954q5j4/image_1c5nhgn23rcs1uhc1qrs18k913d72j.png