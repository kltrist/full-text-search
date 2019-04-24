# Search by phrase with Apache Solr
## Solr instalation 
* Download [Apache Solr](http://www.apache.org/dyn/closer.lua/lucene/solr/8.0.0/solr-8.0.0.tgz)
* Put my "core" collection from project to ```E:\solr-8.0.0\server\solr``` 
* Put [mysql-connector-java.jar](https://dev.mysql.com/downloads/connector/j/) to ```E:\solr-8.0.0\contrib\dataimporthandler\lib```
### Start server
``` "\solr-8.0.0\bin\solr" start```
### Run app
``` mvn spring-boot:run```
