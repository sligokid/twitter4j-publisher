#!/bin/bash

java -cp jar/newsnow-1.1.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.loi.topstories.properties 1 >> log/newsnowloi-topstories.term 1>&1
