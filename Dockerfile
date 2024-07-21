FROM openjdk:17
EXPOSE 8080
ADD target/springboot-realtime-endtoenddocker.war springboot-realtime-endtoenddocker.war
ENTRYPOINT ["java","-war","/springboot-realtime-endtoenddocker.war"]