package com.brilgo.meanbook.spring.repository;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class MeanBookRepositoryManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(MeanBookRepositoryManager.class);

	private static final int MONGODB_DEFAULT_PORT = 27017;
	private static final int MONGODB_DEFAULT_PAGE_SIZE = 20;
	
	private MongoClient connection;
	private MongoDatabase database;

	public boolean connect() {
		return this.connect("localhost", "meanbook", null, null);
	}

	public boolean connect(String hostName, String databaseName, String username, String password) {
		try {
			if (this.database == null) {
				MongoClientURI connectionURI = this.createConnectionURI(hostName, databaseName, username, password);
				this.connection = new MongoClient(connectionURI);
				this.database = this.connection.getDatabase(databaseName);
				LOGGER.info("MongDB: Connect to database successfully.");
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("MongDB: Connection failed.", (Throwable) e);
			return false;
		}
	}

	private MongoClientURI createConnectionURI(String hostName, String databaseName, String username, String password) {
		StringBuilder stringURI = new StringBuilder("mongodb://");
		stringURI.append(hostName);
		if (username != null && password != null) {
			stringURI.append(username).append(':').append(password).append('@');
		}
		stringURI.append(':').append(MONGODB_DEFAULT_PORT);
		return new MongoClientURI(stringURI.toString());
	}
	
	public MongoCollection<Document> getCollection(String collectionName) {
		return this.database.getCollection(collectionName);
	}
	
	public void insertDocument(String collectionName, Document doc) {
		this.database.getCollection(collectionName).insertOne(doc);
	}
	
	public <T> FindIterable<T> includePaginationOptions(FindIterable<T> findIterable, Integer pageNumber) {
		return findIterable.skip(MONGODB_DEFAULT_PAGE_SIZE * (pageNumber - 1))
				.limit(MONGODB_DEFAULT_PAGE_SIZE);
	}
}
