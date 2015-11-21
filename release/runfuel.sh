#!/bin/bash
for n in `ls etc/fuel/`
do 
   echo $n
   java -cp jar/fuel-1.0.jar com.magoo.twitter/Main etc/fuel/$n &>> log/$n.term 2>&1
   sleep 30
done

