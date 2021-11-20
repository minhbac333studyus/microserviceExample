# microserviceExample
server.port=8010
spring.application.name=users-ws
eureka.client.serviceUrl.defaultZone = http://localhost:8761/eureka
spring.devtools.restart.enabled = true
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
 
spring.datasource.username=root
spring.datasource.password=Minhbac321.
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
 
spring.datasource.url = jdbc:mysql://localhost:3306/photouserdatabase
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

#set up in webSecurity that only allow API gateway access source
gateway.ip =192.168.1.69
