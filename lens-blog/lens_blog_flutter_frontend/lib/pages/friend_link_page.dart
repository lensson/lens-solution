import 'package:flutter/material.dart';
import 'package:lens_blog_flutter_frontend/apis/linkAPI.dart';
import 'package:lens_blog_flutter_frontend/config/platform_type.dart';
import 'package:lens_blog_flutter_frontend/json/friend_link.dart';
import 'package:lens_blog_flutter_frontend/widgets/common_layout.dart';
import 'package:lens_blog_flutter_frontend/widgets/friend_link_item.dart';
import 'package:lens_blog_flutter_frontend/widgets/web_bar.dart';

class FriendLinkPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new FriendLinkPageState();
  }
}

class FriendLinkPageState extends State<FriendLinkPage> {
  List<FriendLink> linkList = [];

  @override
  void initState() {
    LinkAPI.getFriendLinkList(context: context).then((result) {
      if (result != null) linkList = result.models;
      setState(() {});
    });
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final isNotMobile = !PlatformType().isMobile();

    return CommonLayout(
      pageType: PageType.link,
      child: Container(
        child: NotificationListener<OverscrollIndicatorNotification>(
          onNotification: (overScroll) {
            overScroll.disallowGlow();
            return true;
          },
          child: isNotMobile
              ? SingleChildScrollView(
                  child: Wrap(
                    children: List.generate(linkList.length, (index) {
                      return FriendLinkItem(
                        bean: linkList[index],
                      );
                    }),
                  ),
                )
              : ListView.builder(
                  itemBuilder: (ctx, index) {
                    return FriendLinkItem(
                      bean: linkList[index],
                    );
                  },
                  itemCount: linkList.length,
                ),
        ),
      ),
    );
  }
}
