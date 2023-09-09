package pac;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DynamoDBClientExample {
    public static void main(String[] args) {
        // Create a DynamoDB client
        DynamoDbClient client = DynamoDbClient.create();

        // Specify the table name
        String tableName = "my-table";

        // Create a PutItemRequest to insert an item into the table
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(
                        // Specify the attributes of the item
                        AttributeMap.builder()
                                .put("id", AttributeValue.builder().s("1").build())
                                .put("name", AttributeValue.builder().s("John").build())
                                .build()
                )
                .build();

        // Insert the item into the table
        client.putItem(request);

        // Create a GetItemRequest to retrieve the item from the table
        GetItemRequest getRequest = GetItemRequest.builder()
                .tableName(tableName)
                .key(
                        // Specify the primary key of the item
                        AttributeMap.builder()
                                .put("id", AttributeValue.builder().s("1").build())
                                .build()
                )
                .build();

        // Retrieve the item from the table
        GetItemResponse getResponse = client.getItem(getRequest);

        // Print the retrieved item
        System.out.println(getResponse.item());

        // Close the DynamoDB client
        client.close();
    }
}