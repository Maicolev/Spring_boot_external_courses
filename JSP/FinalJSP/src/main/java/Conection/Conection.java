package Conection;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import Models.Client;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;


public class Conection{

    private static MongoCollection<Client> collection;

    private String uri = "mongodb://localhost:27017";
    public void removeClient(Client client) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("FinalJSP").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("Clients", Client.class);
            //Client client = collection.find(eq("title", "Back to the Future")).first();
            //System.out.println("Conection up");

            Bson filter = Filters.eq("_id", client.getId());
            try {
                // Deletes the first document that has a "title" value of "The Garbage Pail Kids Movie"
                DeleteResult result = collection.deleteOne(filter);
                System.out.println("Deleted document count: " + result.getDeletedCount());
                // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to delete due to an error: " + me);
            }
            mongoClient.close();
        }
    }

    public void addClient(Client client){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("FinalJSP").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("Clients", Client.class);
            //Client client = collection.find(eq("title", "Back to the Future")).first();
            //System.out.println("Conection up");

            try {
                // Deletes the first document that has a "title" value of "The Garbage Pail Kids Movie"
                InsertOneResult result = collection.insertOne(client);
                System.out.println("Inserted document id: " + result.getInsertedId());
                // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to delete due to an error: " + me);
            }
            mongoClient.close();
        }
    }

    public void updateClient(Client client){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("FinalJSP").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("Clients", Client.class);
            //Client client = collection.find(eq("title", "Back to the Future")).first();
            //System.out.println("Conection up");

            Bson filter = Filters.eq("_id", client.getId());
            try {
                // Deletes the first document that has a "title" value of "The Garbage Pail Kids Movie"
                UpdateResult result = collection.replaceOne(filter,client);
                System.out.println("Edited document id: " + result.getModifiedCount());
                // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to delete due to an error: " + me);
            }
            mongoClient.close();
        }
    }

    public void listClient() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("FinalJSP").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("Clients", Client.class);
            //Client client = collection.find(eq("title", "Back to the Future")).first();

            System.out.println(collection.countDocuments());
            MongoCursor<Client> cursor = collection.find()
                    .sort(Sorts.descending("name"))
                    .iterator();

            try {
                while(cursor.hasNext()) {
                    System.out.println(cursor.next().toString());
                }
            } finally {
                cursor.close();
            }
            //return collection;
            mongoClient.close();
        }
    }
}

