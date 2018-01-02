# Apache Kafka demo project with Spring Boot

## Start application
[Download](https://zookeeper.apache.org/releases.html#download) and start ZooKeeper
```
$ tar -zxf zookeeper-3.4.6.tar.gz
$ cd zookeeper-3.4.6
$ bin/zkServer.sh start  
```
[Download](https://kafka.apache.org/downloads) and start Kafka
```
$ tar -zxf kafka_2.11-1.0.0.tgz
$ cd kafka_2.11-1.0.0
$ bin/kafka-server-start.sh config/server.properties
```
Start Spring Boot application and print messages separated by new-line

## Start test application
Test application uses embedded Kafka.  
Just start test.  
Thread.sleep() used to wait until all services are fully initialized and between sending messages. 