#!/bin/bash

java -cp jar/newsnow-1.3.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.gaa.properties 1 >> log/newsnowgaa.term 2>&1
