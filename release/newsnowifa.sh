#!/bin/bash

java -cp jar/newsnow-1.2.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.ifa.properties 1 >> log/newsnowifa.term 2>&1
