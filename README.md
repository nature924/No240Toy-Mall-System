# ToyMall

## 介绍
**基于SpringBoot开发的就是玩玩具商城**
> **源码整洁请放心食用，并且可拓展性较高，维护成本也低。开源不易 希望给个STAR**
## 软件架构
- 框架选用：SpringBoot + Mybatis-Plus + LayUi 
- 持久层：
   - Mysql 存储数据
   - Redis 存储订单数据(支付订单号的异步获取)
   - 腾讯云对象存储COS(你也可以不使用，我主要使用和这个上传图片，可以弄本地的)


## 安装教程
**开发工具选用的IDEA直接导入**
- application.yml 配置好数据库地址
- JedisConfig 配置好你的Redis地址
- ImgController 
   - 默认是使用的COS对象存储需要配置自己的
   - 如果不想用可以使用ImgControllerNoCos更换接口地址就行
- AlipayConfig 配置自己的公钥私钥和APPID支付用的(使用的是支付宝沙箱支付)
- 使用Navicat 或者 DataGrip 导入数据库 
- 前端地址:http://localhost:8080   **用户名:13888888888 密码:123465**
- 后端地址:http://localhost:8080/login.html   **用户名:admin 密码:123456**


## **主要功能**
  ###以下图片**只展示了一部分重要的功能，其余的小型基本操作或者是不重要的功能都没有展示。**
> 前台功能概览
- 购物功能 用户查看主界面可以根据分类选择商品 也可以直接购买热卖商品
  ![商城主界面](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-index.png)
  ![添加购物车界面](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-addGat.png)
  添加进入购物车选择收货地址
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-gat.png)
  支付宝付款
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-aliPay.png)
  订单
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-order.png)
  文章功能 用户A可以为某些商品A写一篇文章发表 不同的商品有不一样的佣金，如果用户B在用户A的文章下购买产品的话，
  发表文章的用户A便会因为用户B的一次下单获取到该件商品A的对应佣金。 用户便可以提取佣金转化为积分。在他购物的
  时候可以用积分抵消一部分付款金额。这样商城的营业额上来的同时，用户也得到了利益。 
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-article.png)
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-articleInfo.png)
  右侧的浮动窗口是随机推荐的商品，不是作者推荐。
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-articleInfo2.png)
  编辑文章
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-addArticle.png)
  浏览已发文章
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-addArticle2.png)
  提取佣金
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-money.png)
> 后台功能概览
- 后台主界面 是一个可爱的会一直尝试跳起来抓鼠标的小猫
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-adminIndex.png)
  管理用户的功能，图片展示的是管理管理员有用户，还可以管理商城用户，还有不同权限的角色分配
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-adminUser.png)
  管理员订单
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-adminOrder.png)
  管理员审核文章
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-adminArticle.png)
  管理员管理商品
  ![](https://s-y-1304244043.cos.ap-beijing.myqcloud.com/gitee/ToyMall-shopList.png)
## 特技

 ██████████                   ████     ████            ██  ██
░░░░░██░░░            ██   ██░██░██   ██░██           ░██ ░██
    ░██      ██████  ░░██ ██ ░██░░██ ██ ░██  ██████   ░██ ░██
    ░██     ██░░░░██  ░░███  ░██ ░░███  ░██ ░░░░░░██  ░██ ░██
    ░██    ░██   ░██   ░██   ░██  ░░█   ░██  ███████  ░██ ░██
    ░██    ░██   ░██   ██    ░██   ░    ░██ ██░░░░██  ░██ ░██
    ░██    ░░██████   ██     ░██        ░██░░████████ ███ ███
    ░░      ░░░░░░   ░░      ░░         ░░  ░░░░░░░░ ░░░ ░░░ 
