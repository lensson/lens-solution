import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/archive.dart';
import 'package:lens_blog_flutter_frontend/utils/http.dart';

/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-22 09:11
 **/
class ArchiveAPI {
  static Future<ArchiveListResult> getArchiveList({
    BuildContext context,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_ARCHIVE_LIST_URI,
      context: context,
      refresh: refresh,
      cacheDisk: cacheDisk,
    );
    return ArchiveListResult.fromJson(response);
  }
}
