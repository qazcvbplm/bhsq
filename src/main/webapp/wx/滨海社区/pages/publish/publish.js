// pages/publish/publish.js
Page({
  data:{
        SuccessFlag:false,
        GrowthValue:3,
        sectionListflag:0,
        showMessage:false,

        // 是否触发 发布
        releaseFlag:false,
        sectionText:[
          '我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料',
          '我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料','我要爆料'
        ]
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    wx.setNavigationBarTitle({
      title: '发布',
      success: function(res) {
        // success
      }
    })
  },
  detail:function(e)
  {
    console.log(e)
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
     interval = setTimeout(function() {   
      that.setData({
          SuccessFlag:!that.data.SuccessFlag
      })    
      }, 1000)
  }, 
  //选择版块
  sectionListChange:function(e){
    var that = this;
    that.setData({
      sectionListflag:e.currentTarget.id
    })
   
  },
  selectimage:function(){
     wx.chooseImage({
      count: 3, // 最多可以选择的图片张数，默认9
      success: function(res){
        console.log(res)
      },
    })
  },
  //发布字数低于10提醒
  wordRemind:function(e){
    var that = this;
    console.log(e.detail.value)
    if(e.detail.value.length<=10){
      that.setData({
        showMessage:true,
         releaseFlag:false
      })
       setTimeout(function(){   
      that.setData({
          showMessage:!that.data.showMessage
      })    
      }, 1000)
    }
    else{
       that.setData({
        showMessage:false,
        releaseFlag:true
      })
    }
   
  }
})