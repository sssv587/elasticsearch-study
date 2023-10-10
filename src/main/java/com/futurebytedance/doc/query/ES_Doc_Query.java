package com.futurebytedance.doc.query;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/10/11 - 0:01
 * @Description 查询文档
 */
public class ES_Doc_Query {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 1.查询索引中全部的数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 2.条件查询：termQuery
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }
//

        // 3.分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //(当前页码-1)*每页显示数据条数
//        builder.from(0);
//        builder.size(2);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 4.查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 5.过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //
//        String[] excludes = {"age"};
//        String[] includes = {"name"};
//        builder.fetchSource(includes, excludes);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 6.组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        // 相当于and
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        // 相当于or
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 7.范围查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");

        rangeQuery.gte(30);
        rangeQuery.lte(40);

        builder.query(rangeQuery);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();
    }
}
