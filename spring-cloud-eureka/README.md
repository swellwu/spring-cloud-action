# spring-cloud-eureka
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

[1]: http://static.zybuluo.com/swellwu/fxewcjnkl0z43beqqs9nj5w9/image_1c5lnsm75119m6tdlnrjv52ikp.png
[2]: http://static.zybuluo.com/swellwu/uos4iji7wqadnsizlv4f002o/image_1c5lo1mkucmbpag1f6618r01rcs1m.png