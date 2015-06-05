# Session9

In this Session we will cover topics :

a) PAGEOBJECT 
b) PAGE FACTORY
c) DATA DRIVEN WITH EXCEL FILE
d) GRID 

Please follow the steps for grid 
1) For setting HUB 
java -jar selenium-server-standalone-2.25.0.jar -port 4444 -role hub -nodeTimeout 1000

2) Now open the browser and navigate to the URL http//localhost:4444 from the Hub 

3)java -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role node -hub http://10.30.217.157:4444/grid/register -browser browserName=firefox -port 5555

Where,
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = firefox (Parameter to specify the Browser name on Nodes)
5555 = Port on which Firefox Node would be up and running.

4)java -Dwebdriver.ie.driver=D:\IEDriverServer.exe -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role webdriver -hub http://10.30.217.157:4444/grid/register -browser browserName=ie,platform=WINDOWS -port 5558

Where,
D:\IEDriverServer.exe = The location of the downloaded the IE Driver(on the Node Machine)
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = ie (Parameter to specify the Browser name on Nodes)
5558 = Port on which IE Node would be up and running.

5)java -Dwebdriver.chrome.driver=D:\chromedriver.exe -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role webdriver -hub  http://10.30.217.157:4444/grid/register -browser browserName=chrome,platform=WINDOWS -port 5557

Where,
D:\chromedriver.exe = The location of the downloaded the chrome Driver(on the Node Machine)
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = chrome (Parameter to specify the Browser name on Nodes)
5557 = Port on which chrome Node would be up and running.
