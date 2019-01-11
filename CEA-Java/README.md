# CEA-Java

Rest API for Cloud Services

Pre Implementations Steps : -

I have signed up for an account in your STAGING ENVIRONMENT, created an instance for "BOX" application by providing the access to my BOX Account for the instance elements.

By creating an instance for BOX, your service has provided me Authorization key for the BOX element, which is consumed by my API to access your REST services for the BOX instance. I have explored and identified your REST services for implementing the below services.

    1.  To list files and folders in a folder.
    2.  To download the file from a folder.
To list files and folders in a folder. For this service to be implement, i have identified 2 REST Endpoint for list the folder contents.

--> By specifying the folder ID.

--> By specifying the full path of the folder.

To download the file from a folder. For this service to be implement, i have identified 2 REST Endpoint for the file to be download.

--> By specifying the file ID.

--> By specifying the full path of the file.

Technologies : - Java Spring Boot, Angular JS 1.6, HTML.

Implementation : -

To implement above mentioned services i have created my own REST services which validates the input and intern uses/access your REST endpoints for getting the output/payload in JSON format.

In the UI , the script run on the response payload that will display the contents of the folder or download the file.

--> For the service , to display the folder content, you can navigate through the folders and download the files in UI mode by single click.

Deployment : -

Pre - Requirements : - You should have a JAVA environment and Maven build tool in your system.

Download all files in your system, Open the project in eclipse and deploy to start the server on port 8080.

To access it go to browser open url "localhost:8080", the home page will display the above services you can navigate through the pages.

POSTMAN : -

You can also view payloads of REST endpoints created for my application through POSTMAN

    --> To get the folder contents
        RESTEndPoint : - http://localhost:8080/listDirectory
        Method : - GET
        params : - input(value is folder ID or full path)
        
    --> To download the file
        RESTEndPoint : - http://localhost:8080/downloadFile
        Method : - GET
        params : - input(value is file ID or full path with extension of file)
