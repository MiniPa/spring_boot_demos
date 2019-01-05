package com.minipa.sbd.mongodb.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;

public class MongoDatastore {
	
    private final Morphia morphia = new Morphia();
    
    private static MongoClient client;
    
    private static Datastore coreDatastore;
    
    private static MongoDatastore instance;
    
    private MongoDatastore(){}
    
    public static synchronized MongoDatastore getInstance() {
        if (instance == null) {
            instance = new MongoDatastore();
        }
        return instance;
    }
    
    public void initialize()
    {
    	MongoConfiguration configuration = new MongoConfiguration();
        morphia.mapPackage("com.liangzhi.admin.ui.domain");
        final String host = configuration.getHost();
        final int port = configuration.getPort();
        final String username = configuration.getUsername();
        final String password = configuration.getPassword();
        final String db = configuration.getDb();
        ServerAddress addr = new ServerAddress(host, port);
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        MongoCredential credential = MongoCredential.createCredential(username, db, password.toCharArray());
        credentialsList.add(credential);
        client = new MongoClient(addr, credentialsList);
        coreDatastore = morphia.createDatastore(client, db);
        coreDatastore.ensureIndexes();
    }
    
    public Datastore getCoreDatastore() {
        return coreDatastore;
    }
    
    public MongoClient getClient() {
        return client;
    }
}
