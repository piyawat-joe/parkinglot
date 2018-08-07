#!/bin/bash
if [[ -z "$1" ]]
then
java -jar target/com.zicbreeze.parkinglot-1.0-SNAPSHOT.jar
else
java -jar target/com.zicbreeze.parkinglot-1.0-SNAPSHOT.jar $1
fi