// pages/myReply/myReply.js
Page({
  data:{  
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
 //关注和取消关注
  concernCancel:function(e){
    var that = this;
    var ThisIndex = e.currentTarget.id;
    if(that.data.myReply[ThisIndex].concernCancelflag){
      that.setData({
        ['myReply['+ThisIndex+'].concern']:'取消关注',
        ['myReply['+ThisIndex+'].concernCancelflag']:!that.data.myReply[ThisIndex].concernCancelflag,
      })
    }else{
       that.setData({
        ['myReply['+ThisIndex+'].concern']:'+ 关注',
        ['myReply['+ThisIndex+'].concernCancelflag']:!that.data.myReply[ThisIndex].concernCancelflag,
      })
    }
       console.log(e);
  },

  change:function(event){
    console.log(1)
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