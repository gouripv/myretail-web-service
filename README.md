Prerequisites: 
* Maven
* Java
* Couchbase Database

Run in Local:
* Create a bucket named price in Couchbase Database, update config in CouchbaseConfig.java  if required with password, host Name and bucket Name.
* Run the application in local

Endpoints:
* Once the application is up in local, the api has below endpoints.
GET: http://localhost:8080/v1/product/{productId}
PUT: http://localhost:8080/v1/product/{productId} and request body is same as the response of GET call above.
