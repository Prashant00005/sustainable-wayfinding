package database;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import database.models.DynamoDocument;

import java.util.List;

/**
 * Generic Database Layer for DynamoDB interaction
 * @param <T> the type of the object
 */
public abstract class DynamoDatabase<T extends DynamoDocument> implements Database<T> {

    private static AmazonDynamoDB client;

    private DynamoDBMapper mapper;

    public DynamoDatabase() {
        this.client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.EU_WEST_1)
                .build();
        this.mapper = new DynamoDBMapper(client);
    }

    @Override
    public void add(T item) {
        this.mapper.save(item);
    }

    @Override
    public boolean exists(T item) {
        return false;
    }

    @Override
    public T get(String key) {
        T item = this.mapper.load(this.getClassType(), key);
        return item;
    }

    @Override
    public List<T> getAll(){
        return mapper.scan(this.getClassType(), new DynamoDBScanExpression());
    }

    @Override
    public void update(T item) {

    }

    protected abstract Class<T> getClassType();
}
