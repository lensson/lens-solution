import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'package:lens_blog_flutter_frontend/config/base_config.dart';
import 'package:lens_blog_flutter_frontend/json/post.dart';
import 'package:lens_blog_flutter_frontend/notifier/selected_articles_item_list.dart';
import 'package:lens_blog_flutter_frontend/widgets/article_item.dart';

class PCArticleItems extends StatelessWidget {
  final Size size;

  PCArticleItems(this.size);

  @override
  Widget build(BuildContext context) {
//    Category currentSelected;

    double width = size.width;
    double height = size.height;

    List<ArticleItem> itemList =
        Provider.of<SelectedArticleItemList>(context).list;

    return Expanded(
      child: Container(
        margin: EdgeInsets.only(
            left: 0.06 * width, right: 0.06 * width, top: 0.02 * width),
        child: itemList.isEmpty
            ? const Center(
                child: SizedBox.shrink(),
              )
            : NotificationListener<OverscrollIndicatorNotification>(
                onNotification: (overScroll) {
                  overScroll.disallowGlow();
                  return true;
                },
                child: GridView.count(
                  crossAxisCount: 3,
                  padding: EdgeInsets.fromLTRB(
                      0.02 * width, 0.02 * height, 0.02 * width, 0),
                  children: List.generate(itemList.length, (index) {
                    return GestureDetector(
                      child: ArticleItemWidget(bean: itemList[index]),
                      onTap: () {
                        final id = itemList[index].id;
                        Navigator.of(context).pushNamed(articlePage + '/$id',
                            arguments: ArticleData(index, itemList));
                      },
                    );
                  }),
                )),
      ),
    );
  }
}
