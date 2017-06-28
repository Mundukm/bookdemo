#Book demo application

###to run application locally 
     
  #h2 base :
        
       mvn -Dspring.profiles.active="h2" tomcat7:run
        
  #mysql base :
        
       mvn -Dspring.profiles.active="mysql" tomcat7:run
  