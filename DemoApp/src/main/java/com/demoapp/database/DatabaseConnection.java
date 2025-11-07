package com.demoapp.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import shadow.org.bson.Document;

public class DatabaseConnection {
	static String connectionString = "mongodb+srv://piebytwo014:piebytwo014@cluster0.6e2rbvw.mongodb.net/?appName=Cluster0";

    static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();
    static MongoClient mongoClient = MongoClients.create(settings);
    static MongoDatabase database = mongoClient.getDatabase("secb");
    static MongoCollection<Document> c = database.getCollection("users");
	
    
    public static Document userLogin(String email) {
    	try {
			Document userToBeLoggedIn = new Document("userEmail", email);	
			Document user = c.find(userToBeLoggedIn).first(); //fetch
			return user;
		} catch (Exception e) {
			return null;
		}
    }
    
	public static boolean verifyUser(String email) {
		try {
			Document userToBeVerified = new Document("userEmail", email);	
			Document user = c.find(userToBeVerified).first(); //fetch
			Document updatedUser = new Document("$set", new Document("isVerified", true)); //update
			c.findOneAndUpdate(user, updatedUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
    
	public static boolean insertUserData(String fName, String lName, int phone, String userMail, String userPwd) {
		try {
			 c.insertOne(new Document("firstName", fName)
						.append("lastName", lName)
						.append("phone", phone)
						.append("userEmail", userMail)
						.append("userPassword", userPwd)
						.append("isVerified", false));
			 return true;
		} catch (Exception e) {
			 return false;
		}
		 
	}
	
}

