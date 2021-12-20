package edu.northeastern.cs5500.starterbot.service;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

@Slf4j
public class MongoDBService implements Service {
    @Getter private MongoDatabase mongoDatabase;

    static String getDatabaseURI() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        final String databaseURI = processBuilder.environment().get("GROUP_MONGODB_URL");
        // The main bot token is "GROUP_MONGODB_URL"
        if (databaseURI == null) {
            throw new RuntimeException("Environment variable GROUP_MONGODB_URL must be defined!");
        }
        return databaseURI;
    }

    public MongoDBService() {
        CodecRegistry codecRegistry =
                fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        ConnectionString connectionString = new ConnectionString(getDatabaseURI());

        MongoClientSettings mongoClientSettings =
                MongoClientSettings.builder()
                        .codecRegistry(codecRegistry)
                        .applyConnectionString(connectionString)
                        .build();

        MongoClient mongoClient = MongoClients.create(mongoClientSettings);
        mongoDatabase = mongoClient.getDatabase(connectionString.getDatabase());
    }

    @Override
    public void register() {
        log.info("MongoDBService > register");
    }
}
