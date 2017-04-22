// pages/myPage/myPage.js
var app=getApp();
Page({
  data:{
    arrowActive:false,
    myListsActive:-1,
    userName:'张三',
    growthValue:0,
    growthValueMax:99,
    introduction:'大家好',

    postNum:563,
    followNum:111,
    fansNum:99,


    myLists:[
      {
        img:'/images/message.jpg',
        text:'消息',
        url:'/pages/messages/messages'
      },
       {
        img:'/images/reword.jpg',
        text:'打赏记录',
        url:'/pages/rewardRecord/rewardRecord'
      },
       {
        img:'/images/collection.jpg',
        text:'我的收藏',
        url:'/pages/MyCollection/MyCollection'
      },
    ]
  },
  //
  arrowActive:function(){
    var that = this;
    that.setData({
      arrowActive:!that.data.arrowActive
    })
    wx.navigateTo({
      url: '/pages/setUp/setUp',
      success: function(res){
        // success
      that.setData({
      arrowActive:!that.data.arrowActive
    })
    wx.setNavigationBarTitle({
      title: '个人中心',
      success: function(res) {
        // success
      }
    })
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
  },
//列表跳转
myListsActive:function(e){
    var that = this;
    var ThisIndex = e.currentTarget.id;
    console.log(that.data.myLists[ThisIndex].url)
    that.setData({
      myListsActive:ThisIndex
    })
    wx.navigateTo({
      url: that.data.myLists[ThisIndex].url,
      success: function(res){
        // success
        wx.setNavigationBarTitle({
          title: that.data.myLists[ThisIndex].text,
          success: function(res) {
            // success
          }
        })
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
},
//跳转到帖子
  gotoPost:function(){
    wx.navigateTo({
      url: '/pages/thePosts/thePosts',
      success: function(res){
        // success
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
},
//跳转到关注
  gotofollow:function(){
    wx.navigateTo({
      url: '/pages/myFollow/myFollow',
      success: function(res){
        // success
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
},
//跳转到粉丝
  gotoFans:function(){
    wx.navigateTo({
      url: '/pages/myFans/myFans',
      success: function(res){
        // success
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
},

  onLoad:function(options){
    var that=this;
    // 页面初始化 options为页面跳转所带来的参数
    wx.setNavigationBarTitle({
      title: '个人中心',
      success: function(res) {
        // success
      }
    })
    wx.request({
      url: app.globalData.IP+"usermsg.do",
      data: {userid:app.globalData.UID},
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        var user=res.data.u;
        var u={id:user.id,name:user.name,ex:user.ex,intro:user.introduction,head:user.head,level:user.level.image,ex2:user.level.ex};
        u.level=app.globalData.url+u.level;
        u.qd=app.globalData.qd;
        that.setData({
          user:u,
          tz:res.data.tz,
          gz:res.data.gz,
          fs:res.data.fs
        })
      },
    })
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})