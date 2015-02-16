The following aspects of the project milestone have been completed:
-XMLParser
-XMLRetriever Service Transformation
-Implementation of Model Classes
-Manufacturer Service Logic (excluding aspects related to Marshalling)
-Manufacturer Service Products (Schema + XML Data)
-Manufacturer Service Purchase Orders (Schema + XML Data)
-Warehouse Service Logic (excluding aspects related to Marshalling)
-Warehouse Service Item List (Schema + XML Data)

The following aspects of the project milestone are incomplete:
-Marshalling and Unmarshalling of the xml data for both manufacturer and warehouse services. 

Notes:
------
Due to numerous projects and unforeseen circumstances, we were unable to fully complete the
first milestone of the project. We ran into some confusion when faced with how to Marshall
and Unmarshall the xml data. The team member most proficient at implementing this (the member
who implemented the xml parsing Marshalling aspect) was unexpectedly travelling for the final
day before the deadline and the other member was unable to successfully implement this aspect.
So to summarize, the logic for the entire project has been implemented. But the loading from and saving
to xml files is not currently working. And for this reason we have not transformed the project into
the SOAP service format.

Importing Project:
------------------
1. Right click Project Explorer
2. Select Import->Import...
3. Select Existing Projects into Workspace
4. Select the soen487 root directory
5. Confirm the project is selected and press finish
6. At the top of the Eclipse window select Window->Preferences
7. Open Server->Runtime Environments
8. Select Add.. and add an Apache Tomcat 8.0 Runtime as per common practice