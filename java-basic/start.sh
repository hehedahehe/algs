mvn clean package -DskipTests
java -jar target/javabasic-demo-0.0.1-SNAPSHOT.jar \
-Xms50M -XX:MaxDirectMemorySize=10M com.ruibo.demo.DemoApplication
