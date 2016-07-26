# twitter4j-publisher [![Build Status](https://travis-ci.org/sligokid/twitter4j-publisher.svg?branch=master)](https://travis-ci.org/sligokid/twitter4j-publisher)

Twitter publisher latest petrol / diesel prices / football / F1 / news stories (2013)

https://twitter.com/sligopetrol 

https://twitter.com/newsnowirl 

https://twitter.com/newsnowloi 

https://twitter.com/newsnowf1 

Screen scraping of online pricing website.

http://www.pumps.ie/ + Java + Twitter4J

Screen scraping of online news website.

http://www.newsnow.co.uk/h/Sport/Football/Premier+League + Java + Twitter4J

----------------------------------
To build:

$ clean install

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
