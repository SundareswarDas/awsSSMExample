package aws.sdk.java.secretsmanager;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;




public class App 
{
    public static void main( String[] args )
    {
    BasicAWSCredentials awsCreds = new BasicAWSCredentials("************************", "***************************");
    String secretName = "myproj/ssm/secretkey";
        String region = "us-east-1";
        String myEndpoint="secretsmanager.us-east-1.amazonaws.com";
        EndpointConfiguration myEndPointConfiguration = new EndpointConfiguration(myEndpoint, region);
        AWSStaticCredentialsProvider awsCredProvider = new AWSStaticCredentialsProvider(awsCreds);
        AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
        		.withEndpointConfiguration(myEndPointConfiguration)
        		.withCredentials(awsCredProvider)
                .build();
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
        		.withSecretId(secretName);
        GetSecretValueResult getSecretValueResult =  client.getSecretValue(getSecretValueRequest);
        String  secret = getSecretValueResult.getSecretString();
        System.out.println(secret);
    }
}

