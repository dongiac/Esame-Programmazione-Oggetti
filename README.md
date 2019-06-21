# Esame Programmazione ad Oggetti
##### ReadMe file
This ReadMe is an explenation file of the project.
## Creation Process
 
All started with the creation of the _Use-Case diagram_, to visualize what the required specifics for the application were.

 [Use-Case Diagram](https://github.com/dongiac/Esame-Programmazione-Oggetti/blob/master/Use-Case%20final.png)
 
 The second step, was to create the _Class Diagram_ to visualize all the relationship between Classes, Interfaces and Abstract Classes.
 
 [Class Diagram](some link)
 
# The Project
### Application Start
To start the application, open the Terminal and insert:
```
 java ProgettoOopApplication.java -'linkString'
```
By doing this, the Application will:
- Download the *csv* file in the link (only if a correct link is added and the path( in the json) for the csv exists)
- Once finished the download, it will Parse the data.

### Application Use

Open an **RESTful API**.

The application can handle only *GET* and *POST* request.

You can:
 - See the **_Metadata_** by doing a *GET Request* on:
    > http://localhost:8080/metadata
 - See all the **_Data_** by doing a *GET Request* on:
    >http://localhost:8080/data
- Filter all the **_Data_** by doing a *POST Request* on:
    >http://localhost:8080/data

    - [Require JSON BODY](#json-body)
        
-   See **_Statistical Calculation_** done on the whole _Datas_ by doing a *GET Request* on:
    >http://localhost:8080/stats?fieldName=SomeFieldName

    - Required Type for _SomeFieldName_: **_Double_**
-   See **_Statistical Calculation_** done on **_Filtered Datas_** by doing a *POST Request* on:
    >http://localhost:8080/stats

    - [Require JSON BODY](#json-body)

- See how many times a **_String_** repeats in the *Datas* by doing a *GET Request* on:
    >http://localhost:8080/wordstats?word=SomeRandomString
     
    - Required Type for _SomeRandomString_: **Any**



### JSON BODY 
[Require Available Operator](#available-operator)

The Body for the Filter must be in JSON format like this:
```
{
    "fieldName" : "DesiredFieldToFilter",
    "fieldParam": {
		"operator": "Operator",
		"value": numericValue OR "StringValue"
	}
}
```
Or like this:
```
{
    "fieldNames" : ["DesiredFieldToFilter1","AnotherFieldToFilter2"],
    "fieldParam": {
		"operator": "$ + Operator",
		"values": [numericValue1 OR "StringValue1", numericValue2 OR "StringValue2"]
	}
}
```
### Available Operator
**NOT** :
- Available Fields: **_fieldName_** and **_value_**
>Operator = $not

**OR**:
- Available fields: **_fieldNames_** and **_values_** (Remember to put Square Brackets)
>Operator = $or

**GREATER THAN**:
- Available Fields: **_fieldName_** and **_value_**
>Operator = $gt

**BETWEEN**
- Available fields: **_fieldNames_** and **_values_** (Remember to put Square Brackets)
>Operator = $bt



