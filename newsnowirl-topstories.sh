#!/bin/bash

for n in 5 4 3 2 1
do
   java -cp jar/newsnow-1.3.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.irl.topstories.properties ${n} >> log/newsnowirl-topstories.term 2>&1
sleep 60
done
