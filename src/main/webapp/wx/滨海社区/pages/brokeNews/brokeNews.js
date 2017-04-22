// pages/brokeNews/brokeNews.js
Page({
   data: {
    newsTop:[
      {
        newsTopText:'年末“炫富季”说说你都收到过什么样的礼爱上到家了艾克了',
        newsTopImg:'/images/topImg.jpg'
      },
      {
        newsTopText:'年末“炫富季”说说你都收到过什么样的礼爱上到家了艾克了',
        newsTopImg:'/images/topImg.jpg'
        },
      {
        newsTopText:'年末“炫富季”说说你都收到过什么样的礼爱上到家了艾克了',
        newsTopImg:'/images/topImg.jpg'
        }
    ],
    replyAvtive:true,
    releaseAvtive:false,
     concernCancelflag:true
  },
  ////选项卡切换
  active:function(){
    var that = this;
    that.setData({
      replyAvtive:!that.data.replyAvtive,
      releaseAvtive:!that.data.releaseAvtive,
    })
  },
   //关注和取消关注
  concernCancel:function(){
        var that = this;
    that.setData({
      concernCancelflag:!that.data.concernCancelflag,
    })
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
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
  },
   //跳转到滨海社区
  joinPage:function(){
    wx.navigateTo({
      url: '/pages/joinPage/joinPage',
      success: function(res){
        wx.setNavigationBarTitle({
          title: '参与',
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
  //
  replyPage:function(){
    console.log(1)
    wx.navigateTo({
      url: '/pages/replyPage/replyPage',
      success: function(res){
          wx.setNavigationBarTitle({
      title: '回复楼主',
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
  }
})