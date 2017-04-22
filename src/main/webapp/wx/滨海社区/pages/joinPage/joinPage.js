// pages/joinPage/joinPage.js
Page({
  data:{
        SuccessFlag:false,
        GrowthValue:3
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
   //发布成功
  releaseSuccess:function(){
    var that = this;
    that.setData({
      SuccessFlag:!that.data.SuccessFlag,
    })
      setTimeout(function() {   
      that.setData({
          SuccessFlag:!that.data.SuccessFlag
      })    
      }, 1000)
  },   
})