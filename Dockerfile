FROM openjdk:11
EXPOSE 8082
ADD target/kafka-tweet-stream-consumer.jar kafka-tweet-stream-consumer.jar
ENTRYPOINT ["java", "-jar", "kafka-tweet-stream-consumer.jar"]