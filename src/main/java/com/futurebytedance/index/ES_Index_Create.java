package com.futurebytedance.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/10/10 - 0:19
 * @Description 索引-创建
 */
public class ES_Index_Create {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 创建索引
        CreateIndexRequest request = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);

        // 相应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作:" + acknowledged);

        // 关闭ES客户端
        esClient.close();
    }
}
