#!/bin/bash

java -cp jar/newsnow-1.4.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.loi.properties 1 >> log/newsnowloi.term 2>&1
