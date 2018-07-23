FROM openjdk:8-jdk-alpine

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/moip_test/moip-test.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/moip_test/moip-test.jar"]