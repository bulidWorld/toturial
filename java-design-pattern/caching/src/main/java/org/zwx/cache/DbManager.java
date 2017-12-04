package org.zwx.cache;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class DbManager {

    private static MongoClient mongoClient;

    private static MongoDatabase db;

    private static boolean useMongo;
+
    private static Map<String, UserAccount> virtureDB;


    public static UserAccount get(String userId) {
        if (! useMongo) {
            if (virtureDB.containsKey(userId)) {
                return virtureDB.get(userId);
            }
            return null;
        }

        if (db == null) {
            connect();
        }
        FindIterable<Document> iterable = db.getCollection("user_account").find(new Document("userId", userId));

        if (iterable == null) {
            return null;
        }
        Document document = iterable.first();
        return new UserAccount(userId, document.getString("userName"));
    }

    public static void createVirtualDB() {
        useMongo = false;
        virtureDB = new HashMap<>();
    }

    public static void connect() {
        useMongo = true;
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("test");
    }


    public static void writeToDb(UserAccount userAccount) {
        db.getCollection("user_account").insertOne(new Document("userId", userAccount.getUserId())
                .append("userName", userAccount.getUserName()));
    }

    public static void updateDb(UserAccount userAccount) {
        db.getCollection("user_account").updateOne(new Document("userId", userAccount.getUserId()),
                new Document("$set", new Document("userName", userAccount.getUserName())));
    }

    public static void upsert(UserAccount lastUserAccount) {
        db.getCollection("user_account").updateOne(new Document("userId", lastUserAccount.getUserId())
                , new Document("$set", new Document("userName", lastUserAccount.getUserName())),
                new UpdateOptions().upsert(true));
    }
}
