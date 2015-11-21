# twitter4j-publisher 

https://twitter.com/sligopetrol 

https://twitter.com/newsnowirl 

https://twitter.com/newsnowloi 

https://twitter.com/newsnowf1 

Twitter publisher latest petrol / diesel prices / football / F1 / news stories

http://www.pumps.ie/ + Java + Twitter4J

http://www.newsnow.co.uk/h/Sport/Football/Premier+League + Java + Twitter4J

http://twitter4j.org/en/index.html
 
----------------------------------
To build & deploy:

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

project:twitter4j-publisher

Main class: com.magoo.twitter.newsnow.LatestNewsStory

Arguments: etc/account.properties

-----------------------------------
