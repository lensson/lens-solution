/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-14 15:01
 **/

import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/category.dart';
import 'package:lens_blog_flutter_frontend/utils/http.dart';

class CategoryAPI {
  static Future<CategoryListResult> getCategoryList({
    BuildContext context,
    CategoryListRequest params,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_CATEGORY_LIST_URI,
      context: context,
      params: params?.toJson(),
      refresh: refresh,
      cacheDisk: cacheDisk,
//      cacheKey: STORAGE_INDEX_NEWS_CACHE_KEY,
    );
    return CategoryListResult.fromJson(response);
  }
}
