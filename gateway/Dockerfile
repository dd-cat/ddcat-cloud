FROM openjdk:8-jdk-alpine
ADD build/libs/gateway-1.0.jar /home/app.jar
RUN chmod +x /home/app.jar
CMD java -jar /home/app.jar
