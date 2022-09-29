# ManiacChess

To Run Locally via IDE

1) Open IDE (preferably eclipse)
2) Import the project source (ManiacChess folder) into workspace
3) In WebContent -> PlayerBegin.jsp, right click and select "Run As -> Run on Server"

* Note tomcat server must be installed. Recommended server Tomcat v9.0.

To Use Database Feature for Save/Retrieval

1) Download mongo db. Recommended version v5.0.6 or higher
2) Make sure the name of the source of the download is named "mongodb", and 
   ensure that port 27017 is not in use
3) When save is desired, press the "Save Game" button. Mongo should
   automatically create the database entitled "MongoDBTutorial", and 
   the collection "test". You may verify this on the command line.
4) When game retrieval is desired, press the "Retrieve Last Game" button
   and the board will refresh with the last game saved.

To Play:

In browser, click on piece you want to move and then click on square to move it to. Then 
press the "Update Board" button.
