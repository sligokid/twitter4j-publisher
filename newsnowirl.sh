#!/bin/bash

java -cp jar/newsnow-1.3.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.irl.properties 1 >> log/newsnowirl.term 2>&1
