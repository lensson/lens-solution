import 'package:flutter/cupertino.dart';
import 'package:lens_blog_flutter_frontend/json/post.dart';

/**
 * @program: lens_flutter_blog
 *
 * @description:
 *
 * @author: Lens Chen
 *
 * @create: 2020-09-21 09:44
 **/
class SelectedArticleItemList extends ChangeNotifier {
  List<ArticleItem> itemList = [];

  get list => this.itemList;

  setItemList(List<ArticleItem> list) {
    this.itemList = list;
    notifyListeners();
  }
}
