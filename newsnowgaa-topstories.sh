#!/bin/bash

for n in 5 4 3 2 1
do
   java -cp jar/newsnow-1.3.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.gaa.topstories.properties ${n} >> log/newsnowgaa-topstories.term 2>&1
sleep 60
done
