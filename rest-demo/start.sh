java \
-Xmx400m -Xms400m -Xmn100m -XX:MaxMetaspaceSize=40m \
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintGCApplicationStoppedTime \
-Xloggc:/Users/liruibo/Documents/code/temp/demo-gc.log \
-XX:ParallelGCThreads=4 \
-XX:+UseConcMarkSweepGC \
-XX:+UseParNewGC \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/Users/liruibo/Documents/code/temp/demo-heap.dump \
-jar target/demo-0.0.1-SNAPSHOT.jar