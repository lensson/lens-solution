import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/friend_link.dart';
import 'package:lens_blog_flutter_frontend/utils/http.dart';

/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-21 15:28
 **/
class LinkAPI {
  static Future<FriendlyLinkListResult> getFriendLinkList({
    BuildContext context,
    bool refresh = false,
    bool cacheDisk = false,
  }) async {
    var response = await HttpUtil().get(
      GET_LINK_LIST_URI,
      context: context,
      refresh: refresh,
      cacheDisk: cacheDisk,
    );
    return FriendlyLinkListResult.fromJson(response);
  }
}
