import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/tag.dart';
import 'package:lens_blog_flutter_frontend/utils/http.dart';

/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-23 08:55
 **/
class TagAPI {
  static Future<GetTagListResult> getTagList({
    BuildContext context,
    GetTagListResult params,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_TAG_LIST_URI,
      context: context,
      params: params?.toJson(),
      refresh: refresh,
      cacheDisk: cacheDisk,
//      cacheKey: STORAGE_INDEX_NEWS_CACHE_KEY,
    );
    return GetTagListResult.fromJson(response);
  }
}
