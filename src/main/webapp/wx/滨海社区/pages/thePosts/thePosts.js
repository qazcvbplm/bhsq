// pages/thePosts/thePosts.js
Page({
  data:{
    thePostsFlag:true,

      myReply:[  
      {
        name:'张三',
        concern:'+ 关注',
        concernCancelflag:true,

      },
       {
        name:'张三',
        concern:'+ 关注',
        concernCancelflag:true,
      },
            {
        name:'张三',
        concern:'+ 关注',
        concernCancelflag:true,
      },
  ],
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    wx.setNavigationBarTitle({
      title: '帖子',
      success: function(res) {
        // success
      }
    })
  },
  //
  clickChange:function(){
    var that = this;
    that.setData({
      thePostsFlag:!that.data.thePostsFlag
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