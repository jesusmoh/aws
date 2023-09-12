package main.java.com.myorg;


import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketProps;

public class MyStack extends Stack {
    public MyStack(final App app, final String id) {
        this(app, id, null);
    }

    public MyStack(final App app, final String id, final StackProps props) {
        super(app, id, props);

        BucketProps bucketProps = BucketProps.builder()
                .versioned(true)
                .build();

        Bucket bucket = new Bucket(this, "MyBucket", bucketProps);
    }

    public static void main(final String[] args) {
        App app = new App();

        new MyStack(app, "MyStack", StackProps.builder()
                .env(Environment.builder()
                        .account("369122614341")
                        .region("us-east-2")
                        .build())
                .build());

        app.synth();
    }
}
