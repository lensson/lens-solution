<template>
    <div class="guanzhu" id="follow-us" ref="follow">
      <h2 class="hometitle">关注我们 么么哒！</h2>
      <ul>
        <!-- <li class="sina"><a href="/" target="_blank"><span>新浪微博</span>麻辣博客</a></li>         -->
        <li class="qqGroup" v-if="contact.qqGroup"><a href="//shang.qq.com/wpa/qunwpa?idkey=88bc57d77601a3c5ae97fe6d9c0bfa25c2ae166d8f0b9f6da6f7294097be6d08" target="_blank"><span>QQ群</span>{{contact.qqGroup}}</a></li>
        <li class="qq" v-if="contact.qqNumber"><a href="tencent://AddContact/?fromId=50&fromSubId=1&subcmd=all&uin=1595833114" target="_blank"><span>QQ号</span>{{contact.qqNumber}}</a></li>
        <li class="email" v-if="contact.email"><a :href="mailto" target="_blank"><span>邮箱帐号</span>{{contact.email}}</a></li>
        <li class="wxgzh" v-if="contact.weChat"><a href="/" target="_blank"><span>微信号</span>{{contact.weChat}}</a></li>
        <li class="github" v-if="contact.github"><a :href="contact.github" target="_blank"><span>Github</span>{{contact.github}}</a></li>
        <li class="gitee" v-if="contact.gitee"><a :href="contact.gitee" target="_blank"><span>Gitee</span>{{contact.gitee}}</a></li>
        <!-- <li class="wx"><img src="../../../static/images/wx.jpg"></li> -->
      </ul>
    </div>
</template>

<script>
import {getWebConfig} from "@/api/index";
// vuex中有mapState方法，相当于我们能够使用它的getset方法
import {mapMutations} from 'vuex';
export default {
  name: "FollowUs",
  data() {
    return {
      contact: {},
      mailto: ""
    };
  },
  created() {

    this.getContactData()

  },
  methods: {
    //拿到vuex中的写的方法
    ...mapMutations(['setWebConfigData']),

    getContactData: function() {
      let webConfigData = this.$store.state.app.webConfigData;
      if(webConfigData.createTime) {
        this.contact = webConfigData;
        this.mailto = "mailto:" + this.contact.email;
      } else {
        getWebConfig().then(response => {
          if (response.code == this.$ECode.SUCCESS) {
            this.contact = response.data;
            this.mailto = "mailto:" + this.contact.email;
            this.setWebConfigData(response.data)
          }
        });
      }
    },
  }
};
</script>

<style>
</style>
