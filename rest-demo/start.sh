java \
-Xmx400000m -Xms400000m -Xmn100m -XX:MaxMetaspaceSize=40m \
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintGCApplicationStoppedTime \
-Xloggc:/Users/liruibo/Documents/code/temp/demo-gc.log \
-XX:ParallelGCThreads=4 \
-XX:+UseConcMarkSweepGC \
-XX:+UseParNewGC \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=../rest-demo-heap.dump \
-XX:NativeMemoryTracking=summary \
-jar target/rest-demo-0.0.1-SNAPSHOT.jar



 export SW_BACKEND_SERVICE=oap.guazi-apps.com
 && sh /data/service/skywalking-agent/init.sh &&
 exec java -server -javaagent:/data/service/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.namespace=nr
 -Dskywalking.agent.service_name=nr-nr-daijia -Dskywalking.logging.level=ERROR -Dskywalking.logging.dir=/med/log/
 -Dskywalking.logging.file_name=nr-nr-daijia-skywalking.log
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=/med/share/nr-daijia-oom.dump
 -XX:+UseConcMarkSweepGC
 -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses
 -XX:+UseCMSInitiatingOccupancyOnly
 -XX:+CMSScavengeBeforeRemark -XX:ParallelGCThreads=4
 -Xloggc:/med/log/apps/nr-daijia-gc-%t.log
 -XX:+PrintFlagsFinal -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=10M -XX:+PrintStringTableStatistics -XX:NativeMemoryTracking=detail -Xss256k  -Xms2048m -Xmx2048m -jar nr-daijia-1.0-SNAPSHOT.jar --spring.profiles.active=prod