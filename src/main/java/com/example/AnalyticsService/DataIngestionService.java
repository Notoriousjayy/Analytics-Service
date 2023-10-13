package com.example.AnalyticsService;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class DataIngestionService {
    private final S3Client s3Client;
    private final String bucketName;

    public DataIngestionService(String awsRegion, String bucketName) {
        this.s3Client = S3Client.builder()
                .region(Region.of(awsRegion))
                .build();
        this.bucketName = bucketName;
    }

    public void uploadData(String key, String data) {
        s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build(), RequestBody.fromString(data));
    }
}
