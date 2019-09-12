# How to run the webapp with eclipse ?

## 1. Clone or download the repository
- https://github.com/MangooLife/projet6_OC

## 2. Prepare the database with MySQLWorkbench
- Run the different scripts whose are in projet_6_db in MySQLWorkbench (per example)
 
## 3. Configure eclipse
- Please use apache-tomcat-9.0.21 and jdk-11.0.1.jdk

## 4. Run the webapp
- Configure application.properties with your database's configurations (/projet6_OC/src/main/resources/application.properties)
```java
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/db_projet6_OC?serverTimezone=EST5EDT&useUnicode=yes&characterEncoding=UTF-8
jdbc.username=yourUsernme
jdbc.password=yourPassword
```

- Do a mvn clean install

- Click right on the  file project > Maven > Update Project... > OK

- Click right on the file project > Run As > Run on Server (Select the configuration you have done before).

- And: Et voilà!


 
 
 