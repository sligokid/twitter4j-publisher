# twitter4j-publisher [![Build Status](https://travis-ci.org/sligokid/twitter4j-publisher.svg?branch=master)](https://travis-ci.org/sligokid/twitter4j-publisher)

Twitter publisher 
Publish the latest petrol / diesel prices / football / F1 / news stories (2013)

## Table of Contents
  - [Introduction](#introduction)
  - [Overview](#overview)
  - [Demo](#demo)
  - [Install](#install)
  - [Limitations](#limitations)

## Introduction

This simple publisher that publishes short news links as tweets via Twitter API.

The publishers screen scrape several news sites and publish the latest available news story based on a particular subject. 

## Overview

This program is a personal project developed to demonstrate the integration of Java based screen scraping, XML and HTML parsing and Twitter API: 

http://www.pumps.ie/ + Java + Twitter4J
http://www.newsnow.co.uk/h/Sport/Football/Premier+League + Java + Twitter4J

## Demo

![docs-diagram](https://user-images.githubusercontent.com/6519496/28394275-b25c5ad0-6ce3-11e7-8281-e3650a721e65.png)
![docs-diagram](https://user-images.githubusercontent.com/6519496/28394317-0280472e-6ce4-11e7-87d8-a4611232f001.png)



### The latest petrol / diesel prices in Ireland (32 counties daily)
- https://twitter.com/sligopetrol 
- https://twitter.com/sligodiesel
- https://twitter.com/dublinpetrol 
- https://twitter.com/dublindiesel

### The latest news stories in Ireland (hourly)
- https://twitter.com/newsnowirl 

### The latest sport stories in Ireland (hourly)
- https://twitter.com/newsnowloi 
- https://twitter.com/newsnowf1 

## Install
----------------------------------
$ mvn clean install

Setup dev account on https://dev.twitter.com.

Setup a new app and get yourself your oath details for xxxxx_SET_ME_UP_xxxxxxxx

create an etc/account.properties file as shown

-----------------------------------------

[FUEL]

-----------------------------------------

oauth.consumerKey=xxxxx_SET_ME_UP_xxxxxxxx

oauth.consumerSecret=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessToken=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessTokenSecret=xxxxx_SET_ME_UP_xxxxxxxx

debug=true

http.prettyDebug=true

url=http://www.pumps.ie/api/getStationsByPriceAPI.php?county=Sligo&minLat=54.01180381407852&maxLat=54.409340183768315&minLng=-9.1461181640625&maxLng=-8.4100341796875&fuel=petrol&noCache=0.5851892016214073

-----------------------------------------

[NEWSNOW]

--------------------------------

oauth.consumerKey=xxxxx_SET_ME_UP_xxxxxxxx

oauth.consumerSecret=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessToken=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessTokenSecret=xxxxx_SET_ME_UP_xxxxxxxx

debug=true

http.prettyDebug=true

url=http://www.newsnow.co.uk/h/World+News/Europe/Western/Republic+of+Ireland

hashtag=#ireland #news

---------------------------------

To deploy:

[Eclipse Run configuration] [NewsNow]

project:twitter4j-publisher

Main class: com.magoo.twitter.newsnow.LatestNewsStory

Arguments: etc/account.properties


[Eclipse Run configuration] [SligoPetrol]

project:twitter4j-publisher

Main class: com.magoo.twitter.fuel.LatestFuelPrice

Arguments: etc/account.properties

-----------------------------------

Ref: 

http://twitter4j.org/en/index.html
 
http://www.newsnow.co.uk/h/

http://www.pumps.ie/


## Limitations
Twitter now limits the amount of accounts a single email address can hold.
