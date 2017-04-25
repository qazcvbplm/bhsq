// pages/replyPage/replyPage.js
var that;
var app=getApp();
Page({
  data:{
        SuccessFlag:false,
        GrowthValue:1,
        articleTitle:'',
        title:'',
        aid:0
  },
  onLoad:function(options){
    that=this;
    // 页面初始化 options为页面跳转所带来的参数
    that.setData({
       aid:options.aid,
       articleTitle:options.title,
       typ:options.typ,
       rtid:options.rtid
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
  },
  detail:function(e){
      that.setData({
        title:e.detail.value
      })
  },
   //发布成功
  releaseSuccess:function(){
    var that = this;
    /*that.setData({
      SuccessFlag:!that.data.SuccessFlag,
    })
     interval = setTimeout(function() {   
      that.setData({
          SuccessFlag:!that.data.SuccessFlag
      })    
      }, 1000)*/
      wx.request({
        url: app.globalData.IP+"replace.do",
        data: {
          title:that.data.title,
          aid:that.data.aid,
          uid:app.globalData.UID,
          typ:that.data.typ
        },
        method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
        // header: {}, // 设置请求的 header
        header:{'content-type': 'application/x-www-form-urlencoded' },
        success: function(res){
          // success
            if(res.data==1)
            {
              wx.redirectTo({
                url: '/pages/information/information?id='+that.data.rtid,
              })
            }
        },
      })
  },   
})