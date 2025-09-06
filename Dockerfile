FROM openjdk:17
COPY target/user-service*.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]

# ENTRYPOINT EXPLANTATION
# "java"                - Executable - Defines Java runtime will be responsible for execution in Container
# "-jar"                - Param1 - Define which type will execute
# "/user_service.jar"   - Param2 - Define specific file of choosed type will execute