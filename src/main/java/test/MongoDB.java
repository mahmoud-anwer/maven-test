package test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDB {

    private static MongoClient client;

    public static void init() {
        try {
            client = MongoClients.create("mongodb://localhost:27017/test");
            for (String listDatabaseName : client.listDatabaseNames()) {
                System.out.println(listDatabaseName);
            }
            System.out.println("[XenonSuite] Successfully connected to MongoDB");
        } catch (Exception e) {
            System.out.println("[XenonSuite] Following errors were catched while connecting to MongoDB");
            e.printStackTrace();
        }
    }
}