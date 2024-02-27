package fundamentals;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Integration {
    public static void main( String[] args ) {

        // Replace the placeholder with MongoDB deployment's connection string
        String uri = "<connection string uri>";
        String username = "Robert";
        String password = "pwrobert123";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("user");

            // fetch information from the database
            Document doc = collection.find(eq("username", username)).first();
            if (doc != null) {
                // login to analyzer if information is found
                login(username, password);
                // display document if username and password are correct
                if (login(username, password) == "100 Success") {
                    System.out.println(doc.toJson());
                }
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
