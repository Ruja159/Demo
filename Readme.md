
# Java Spring - Angular Demo Project!

  - This project aims to demonstrate the use of the Java Spring and Angular framework for web application development.  
 This project also employs:  
•	Maven to build files with the necessary dependencies from Spring Initializr.  
•	Spring Boot   
•	Spring Data JPA for data access  
•	Spring Security for customizable authentication and access-control  
•	MySQL which uses Spring JPA to access the database  
•	Swagger for documenting an API  
•	jUnit for Unit testing Java code  
•	Angular Material which provides tools that help developers build their own custom components with common interaction patterns  
•   Angular Flex-Layout which provides a sophisticated layout API using Flexbox CSS + mediaQuery.  

# Prerequisites  

* [Maven 3.6.3](http://maven.apache.org/install.html)  
* [JDK 15](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)  
* [MySQL](https://dev.mysql.com/downloads/mysql/)  
* [Node.js](https://nodejs.org/en/)  

# Running backend  
1. Create dabase in mysql server  

    Change connection string in file:   
_Demo/backend/donateblood/src/main/resources/application.properties_  
    ```sh
    spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
    spring.datasource.url = jdbc:mysql://localhost:3306/<your_database_name>
    spring.datasource.username = <user_name>
    spring.datasource.password = <password>
    
    spring.jpa.show-sql = true
    spring.jpa.hibernate.ddl-auto = update
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
    ```
    
2. Using command line navigate to _Demo/backend/donateblood_ and run         ```
            mvn install
        ``` command to make _.jar_ file from Spring Boot project.  


3. Navigate to _Demo/backend/donateblood/target_ and run command:  
        ```java -jar <.jar filename>```  
   
        **Example:**  
	 ``` java -jar donateblood-0.0.1-SNAPSHOT.jar ```   


# Running frontend  

1. Navigate to _\Demo\frontend\donateblood_  
2. Install **Angular/CLI** ``npm install -g @angular/cli``  
3. To run angular application run command ``ng serve``  

The application frontent will be available at ``http://localhost:4200`` by default  
The backend application will be available at ``http://localhost:8080`` by default  