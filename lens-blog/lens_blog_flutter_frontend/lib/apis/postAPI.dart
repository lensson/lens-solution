import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/article.dart';
import 'package:lens_blog_flutter_frontend/json/post.dart';
import 'package:lens_blog_flutter_frontend/utils/http.dart';

/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-14 14:54
 **/

class PostAPI {
  static Future<PostListResponseEntity> getArticleItemList({
    BuildContext context,
    GetPostsRequest params,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_POST_LIST_URI,
      context: context,
      params: params?.toJson(),
      refresh: refresh,
      cacheDisk: cacheDisk,
//      cacheKey: STORAGE_INDEX_NEWS_CACHE_KEY,
    );
    return PostListResponseEntity.fromJson(response);
  }

  static Future<PostListResponseEntity> getArticleItemListByPost({
    BuildContext context,
    ArticleItem params,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().post(
      GET_POST_LIST_URI,
      context: context,
      params: params?.toJson(),
//      cacheKey: STORAGE_INDEX_NEWS_CACHE_KEY,
    );
    return PostListResponseEntity.fromJson(response);
  }

  static Future<GetPostResult> getArticleItem({
    BuildContext context,
    int id,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_POST_URI + id.toString(),
      context: context,
      refresh: refresh,
      cacheDisk: cacheDisk,
//      cacheKey: STORAGE_INDEX_NEWS_CACHE_KEY,
    );
    return GetPostResult.fromJson(response);
  }
}
