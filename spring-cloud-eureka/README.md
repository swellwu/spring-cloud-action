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

## ribbon 负载均衡
启动eureka-server 和 两个eureka-client，相当于一个服务有多个提供者。
然后启动service-ribbon，访问http://localhost:8764/hi?name=swellwu
发现实现了负载均衡
如图：
![image_1c5n591841uiu1b0pl0d1mne10uh9.png-12.6kB][3]

![image_1c5n59pc91cvb1kmfo3g144d1h8u1m.png-12.3kB][4]




[1]: http://static.zybuluo.com/swellwu/fxewcjnkl0z43beqqs9nj5w9/image_1c5lnsm75119m6tdlnrjv52ikp.png
[2]: http://static.zybuluo.com/swellwu/uos4iji7wqadnsizlv4f002o/image_1c5lo1mkucmbpag1f6618r01rcs1m.png
  [3]: http://static.zybuluo.com/swellwu/cs7ug73y2q8b7j02jkcacxxy/image_1c5n591841uiu1b0pl0d1mne10uh9.png
  [4]: http://static.zybuluo.com/swellwu/ulcxo4z7q8h1w80c488cu581/image_1c5n59pc91cvb1kmfo3g144d1h8u1m.png