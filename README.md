# Session9
With Grid

Please follow the below steps to work with GRID:

STEP 1: Download the latest Selenium Server standalone JAR file from http://docs.seleniumhq.org/download/.

STEP 2: Start the Hub by launching the Selenium Server using the following command. Now we will use the port '4444' to start the hub.
java -jar selenium-server-standalone-2.25.0.jar -port 4444 -role hub -nodeTimeout 1000

STEP 3:  Now open the browser and navigate to the URL http//localhost:4444 from the Hub 

STEP 4: Now click on the 'console' link and click 'view config'. The config of the hub would be displayed as follows. As of now, we haven't got any nodes, hence we will not be able to see the details.

Configuring the Nodes

STEP 5: Launch FireFox Node using the following below command. 

java -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role node -hub http://10.30.217.157:4444/grid/register -browser browserName=firefox -port 5555

Where,
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = firefox (Parameter to specify the Browser name on Nodes)
5555 = Port on which Firefox Node would be up and running.

STEP 6: : Launch IE using the following command.

C:\>java -Dwebdriver.ie.driver=D:\IEDriverServer.exe -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role webdriver -hub http://10.30.217.157:4444/grid/register -browser browserName=ie,platform=WINDOWS -port 5558

Where,
D:\IEDriverServer.exe = The location of the downloaded the IE Driver(on the Node Machine)
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = ie (Parameter to specify the Browser name on Nodes)
5558 = Port on which IE Node would be up and running.

STEP 7: Launch Chrome using the following command.

C:\>java -Dwebdriver.chrome.driver=D:\chromedriver.exe -jar D:\JAR\selenium-server-standalone-2.42.2.jar -role webdriver -hub  http://10.30.217.157:4444/grid/register -browser browserName=chrome,platform=WINDOWS -port 5557

Where,
D:\chromedriver.exe = The location of the downloaded the chrome Driver(on the Node Machine)
D:\JAR\selenium-server-standalone-2.42.2.jar = Location of the Selenium Server Standalone Jar File(on the Node Machine)
http://10.30.217.157:4444 = IP Address of the Hub and 4444 is the port of the Hub
browserName = chrome (Parameter to specify the Browser name on Nodes)
5557 = Port on which chrome Node would be up and running.
