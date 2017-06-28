#Book demo application

###Simple spring application with :
### spring MVC, spring JPA, hibernate
###also provided two databases - H2 , MySQL

###to run application locally 
     
  #h2 base :
        
       mvn -Dspring.profiles.active="h2" tomcat7:run
        
  #mysql base :
        
       mvn -Dspring.profiles.active="mysql" tomcat7:run
  