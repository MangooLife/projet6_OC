# How to run the webapp with eclipse ?

## Clone or download the repository

## Prepare the database with MySQLWorkbench
- Run the different scripts whose are in projet_6_db in MySQLWorkbench (per example)
 
## Configure eclipse 
- Please use apache-tomcat-9.0.21

## Run the webapp
- Configure application.properties with your database's configurations (/projet6_OC/src/main/resources/application.properties)
'''java
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/db_projet6_OC?serverTimezone=EST5EDT&useUnicode=yes&characterEncoding=UTF-8
jdbc.username=yourUsernme
jdbc.password=yourPassword
'''
- Click right on the file project > Run As > Run on Server (Select the configuration whose you have done before). 

- And: Et voilà!


 
 
 