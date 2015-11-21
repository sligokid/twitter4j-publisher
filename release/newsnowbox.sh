#!/bin/bash

java -cp jar/newsnow-1.2.jar com.magoo.twitter.newsnow/Main etc/newsnow/newsnow.box.properties 1 >> log/newsnowbox.term 2>&1
