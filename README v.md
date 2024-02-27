# Smart Document Analyzer 
## Secure File Uploader/Ingester
### User Stories
As a user, I would like to:
- Upload different types of files
- Check the file format
- Extract text from file
- Monitor the files history
- Modify files such as updating and deleting files
- Check if there is any error opening files
### High Level Overview
```java
login(username, password) {
	if user is found open a new session
	return status code
} 
uploadFile(path) {
	if path found, upload file to user specified path
	return status code informing the user is upload is successful
}
Class FileManager {
	// a class that has several file modification methods
	openFile()
	updateFile()
        deleteFile() …
}
// Entity-based
```
### Error Handling
Status Code:
```
100: Success
401: Login failed, username or password not found/incorrect
402: Path not found
403: Failed to upload file
404: Unknown file type
405: File too large
406: File not found
407: Failed to open file
408: Failed to delete file
```
## Text NLP Analysis
### User Stories
As a user, I would like to:
- Translate uploaded documents to readable text
- Tag all documents and paragraphs by keywords
- Know the topics each document cover
- Find definition of keywords using open services
- Get summaries of documents
- Fetch all authors, locations, timestamp and address in my documents
- Modify analyzed content
### High Level Overview
```java
translate(filename) {
	return str // readable text message
}
getTag(Tag name) {
	return documents that are marked with given tag
}
getTopic(topic name) {
	return documents that match the given topic
}
analyze(keyword) {
	analyze definition, authors, locations, etc.
}
modify(keyword) {
	modify analyzed content
}
// Procedure-based
```
### Error Handling
Status Code:
```
100: Analyze succeed
400: Failed to analyze/modify
```
## News Feed Ingester
### User Stories
As a user, I would like to:
- Fetch desired news resource from URL
- Filter news and articles by keyword/topic
### High Level Overview
```java
fetchNews(URL) {
	if given URL is valid, return the original news content
}
filter(keywords) {
	find all news/articles that contain given keywords, and return 
}
// Procedure-based
```
### Error Handling
Status Code:
```
100: Fetch succeed
401: Invalid URL
402: Invalid keyword
403: Desired news not found
```

## Database Selection
For this project, use MongoDB as the best database
### Why Mongo DB
- The document-oriented approach allows non-defined attributes to be modified on the fly. This is a key contrast between MongoDB and other relational databases
- JSON file type is widely used across for frontend and API communication
### Setting up MongoDB
- Begin with writing code to be able to parse user information (found [here](https://www.prisma.io/dataguide/mongodb/setting-up-a-local-mongodb-database))
- Implement MongoDBs that store "User", "Files" and "Analysis" information
- Peform unit test

### Structure

There will be three containers for Users, Files, and Analysis to store all data

* User:
	* User ID 
	* Username
	* Password

* Files:
 	* User ID
	* File Path
	* File Name
	* File Type
	* Date of Creation
	* Date of Last Modification


* Analysis:
	* File Path
	* Keyword
	* Info(author, location, address)
	* Summary
	* Sentiment
	* Date of Creation


## Implementation & Integration
### Create Database in MongoDB
MongoDB ```use DATABASE_NAME``` is used to create database. The command will create a new database if it doesn't exist, otherwise it will return the existing database.
#### Syntax
Basic syntax of use DATABASE statement is as follows −
```
use DATABASE_NAME
```
#### Example
Use a database with name "mydb", then use DATABASE statement would be as follows 
```
>use mydb
switched to db mydb
```
Check currently selected database using the command db
```
>db
mydb
```
Check databases list using the command show dbs.
```
>show dbs
local     0.78125GB
test      0.23012GB
```
The created database (mydb) is not present in list. Insert at least one document into mydb in order to display it.
#### Insertion
You can insert a single document into a collection using the insertOne() method on a MongoCollection object. To insert a document, construct a Document object that contains the fields and values that you want to store. If you call the insertOne() method on a collection that does not exist yet, the server automatically creates it for you. 

Upon a successful insertion, insertOne() returns an instance of InsertOneResult. You can retrieve information such as the _id field of the document you inserted by calling the getInsertedId() method on the InsertOneResult instance.

If your insert operation fails, the driver raises an exception.

The following snippet inserts a single document into the user collection.
```java
public class Insertion {
    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "<connection string uri>";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // insert new user into database
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("user");

            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("username", "Tom")
                        .append("password", "pwtom789")));

                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }
}
```
### Setup MongoDB Cluster
- Set up Java project dependencies, create a MongoDB cluster where one can store and manage the data. 
- Set up a new Atlas account, create and launch a free tier MongoDB cluster, load datasets, and interact with the data.[steps](https://www.mongodb.com/docs/atlas/getting-started/?jmp=docs_driver_java) 
- Then one should have a new MongoDB cluster deployed in Atlas, a new database user, and sample datasets loaded into the cluster.
#### Connect to the Cluster
- Create and run an application that uses the MongoDB Java driver to connect to the MongoDB cluster and run a query on the sample data.
- Pass instructions to the driver on how to connect to your MongoDB cluster in a string called the connection string. This string includes information on the hostname or IP address and port of your cluster, authentication mechanism, user credentials when applicable, and other connection options. 
- Retrieve connection string for the cluster and user created in the previous step, log into Atlas account and navigate to the Clusters section and click the Connect button for the cluster that you want to connect to.
### Integration into APIs
- Create a file to contain application called Integration.java in the base package directory of the project. 
- Run a query on the dataset in MongoDB Atlas, replacing the value of the uri variable with MongoDB Atlas connection string.
- Run the Integration class, it should output the details of the user from the User dataset which will look something like this:
```
{
  _id: '2023001',
  username: 'Robert',
  password: 'pwrobert123',
}
```
Same things for "Files" and "Analysis" datasets.
