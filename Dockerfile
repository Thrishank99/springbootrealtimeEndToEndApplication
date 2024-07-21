FROM openjdk:17
EXPOSE 8080
ADD target/springboot-realtime-endtoend.war springboot-realtime-endtoend.war
ENTRYPOINT ["java","-war","/springboot-realtime-endtoend.war"]