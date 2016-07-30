package com.brilgo.meanbook.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brilgo.meanbook.spring.model.Post;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

@Repository
public class PostRepository {

	private static final String COLLECTION_NAME = "posts";
	
	@Autowired private MeanBookRepositoryManager repositoryManager;
	
	public List<Post> listByAuthor(String author) {
		this.repositoryManager.connect();
		MongoCollection<Document> collection = this.repositoryManager.getCollection(COLLECTION_NAME);
		MongoCursor<Document> cursor = collection.find(Filters.eq("by", author))
				.sort(Sorts.descending("creationDate")).iterator();
		
		List<Post> posts = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			posts.add(new Post(doc.getObjectId("_id").toHexString(), doc.getString("by"), 
					doc.getDate("creationDate"), doc.getString("content"), doc.getInteger("likes")));
		}
		return posts;
	}
}
