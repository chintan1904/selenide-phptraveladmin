# selenide-phptraveladmin

Selenide
---------
Things Implemented:
1. Executed tests in Different browsers (Verified for chrome / firefox / ie)
2. Executed script using maven command (Created profile for each browser in pom)
3. Enabled screen shot capture at the end of each test, irrespective of pass or fail
4. Delete Existing screen shots stored in "Build" folder before starting new build execution (Added **/build/** in maven-compiler-plugin to delete the folder

TODO:
1. Logging
2. Run tests using executable JAR
3. Read configuration from external properties file
4. DBUnit configuration


Issues Encountered:
1. Run tests in IE.
	Observation:	Script was able to open browser and navigate to a provided url , However it was not able to perform sendKeys operation on text field and IEDriverServer.exe was getting stuck.
	Resolution:		Set "Enable Protection Mode" to OFF in all regions
