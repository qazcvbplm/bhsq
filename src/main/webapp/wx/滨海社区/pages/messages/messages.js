// pages/messages/messages.js
Page({
  data:{
    messageList:[
      {
        img:'/images/myReply.jpg',
        text:'回复我的',
        messageNum:'8',
        url:'/pages/myReply/myReply'
      },
            {
        img:'/images/myPraise.jpg',
        text:'赞我的',
        messageNum:'8',
        url:'/pages/myPraise/myPraise'
      },
            {
        img:'/images/myConcern.jpg',
        text:'关注我的',
        messageNum:'8',
        url:'/pages/myConcern/myConcern'
      },
            {
        img:'/images/systemNotice.jpg',
        text:'系统通知',
        messageNum:'8',
        url:'/pages/systemNotice/systemNotice'
      },
    ]
  },
  //
  messageListClick:function(e){
    var that = this;
    var ThisIndex = e.currentTarget.id;
    var ThisUrl = that.data.messageList[ThisIndex].url;
    var ThisText = that.data.messageList[ThisIndex].text;

    console.log(ThisIndex,ThisUrl)
    wx.navigateTo({
      url: ThisUrl,
      success: function(res){
        // success
        wx.setNavigationBarTitle({
          title: ThisText,
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
  }
})