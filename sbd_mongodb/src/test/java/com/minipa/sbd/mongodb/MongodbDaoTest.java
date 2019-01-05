package com.minipa.sbd.mongodb;

import com.minipa.sbd.mongodb.db.MongoDatastore;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AdminCatalogDaoTest:
 *
 * @version 0.0.1  @date: 2018-05-30
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs_minipa</a>,
 */
public class MongodbDaoTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(MongodbDaoTest.class);

  @Test
  public void getBomByPartId() throws Exception {
    String partId = "9313df70-a872-4908-86b3-b27a57e9b81c";
    MongoDatastore instance = MongoDatastore.getInstance();
    instance.initialize();
    Datastore datastore = instance.getCoreDatastore();
    Bom bom = datastore.find(Bom.class, "partId", partId).get();
    LOGGER.debug("bom1:" + bom.toString());
    Query<Bom> query = datastore.createQuery(Bom.class);
    query = query.filter("partId", partId);
    query = query.filter("approvers.state", "APPROVED");
    Bom bom2 = query.get();
    LOGGER.debug("bom2:" + bom2.toString());
  }

}