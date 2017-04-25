// pages/information/information.js
var that;
var WxParse=require("../../wxParse/wxParse.js");
var app=getApp();
Page({
  data:{
    id:0,
    SuccessFlag:false,
    commentSuccessFlag:false,
    author:'',
    Identity:'管理员',
    time:1,
    //资讯内容
    inforContentTitle:'',
    inforContentText:'',
    readNum:356,
    praiseNum:24,
    commentNum:5,
    commentName:'卡卡',
    commentFloor:4,
    commentText:'沙发',
    commentTime:1,
    commentPraiseNum:20,
    prizeFlag:false,
    select:0,
    moneyNum:[
      1,2,3,4,5,6
    ],
    user:{},
    article:{},
    replace:[]
  },
//价格单个选中
  moneySelect:function(e){
    var that = this;
    that.setData({
      select:e.currentTarget.id
    })
  },


  onLoad:function(options){
    that=this;
    wx.request({
      url: app.globalData.IP+"articledetail.do?id="+options.id+"&userid="+app.globalData.UID,
      data: {},
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
          if(res.data.a.userid==0||res.data.a.userid=='0')
          {
              that.data.user.name="gm"; 
              that.data.user.head="/images/head_img.jpg"; 
          }else{
            that.data.user.name=res.data.a.user.name;
             that.data.user.head=res.data.a.user.head;
             that.data.user.level=res.data.a.user.level.image;
          }
          var article=res.data.a;
          var text=article.text;
          WxParse.wxParse('text', 'html', text, that, 0);
          //
            var replace=res.data.replace;
            for(var i=0;i<replace.length;i++)
            {
              var item={id:replace[i].id,head:replace[i].user.head,name:replace[i].user.name,level:app.globalData.url+replace[i].user.level.image,title:replace[i].title,time:replace[i].time,zan:replace[i].zan,fzan:replace[i].fzan,text:replace[i].text};
              that.data.replace.push(item);
            }
          //
           that.setData({
             user:that.data.user,
             article:{id:article.id,title:article.title,time:article.time,visitor:article.visitor,zan:res.data.a.zan,sc:res.data.sc,gz:res.data.gz,zan2:res.data.zan,auid:article.userid},
             replace:that.data.replace,
             id:options.id
           })
      },
    })
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
  //点赞加一
  praiseNumAdd:function(){
    var praiseNum = this.data.praiseNum;
    this.setData({
      praiseNum:praiseNum+1
    })
  },
  //打开打赏页面
  showPrizePage:function(){
    this.setData({
      prizeFlag:true
    })
  },
  //关闭打赏页面
  closePricePage:function(){
    this.setData({
      prizeFlag:false
    })
  },
   //举报成功
  reportSuccess:function(){
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
  //回复成功
   commentSuccess:function(){
    var that = this;
    that.setData({
      commentSuccessFlag:!that.data.commentSuccessFlag,
    })
     interval = setTimeout(function() {   
      that.setData({
          commentSuccessFlag:!that.data.commentSuccessFlag
      })    
      }, 1000)
  }, 
  zan:function(){
    wx.request({
      url: app.globalData.IP+"zan.do",
      data: {
        aid:that.data.id,
        userid:app.globalData.UID
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        if(res.data==1)
        {
          that.data.article.zan2=true;
             that.setData({
               article:that.data.article
             })
        }else{
          wx.showToast({
             duration:2000,
             title:'已经赞过'
          })
        }
      },

    })
  },
  fzan:function(e){
    console.log(e)
    wx.request({
      url: app.globalData.IP+"zan.do",
      data: {
        aid:e.currentTarget.id,
        userid:app.globalData.UID
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        if(res.data==1)
        {
          that.data.replace[e.target.dataset.in].fzan=true;
           that.data.replace[e.target.dataset.in].zan+=1;
          that.setData({
            replace:that.data.replace
          })
        }else{
          wx.showToast({
             duration:2000,
             title:'已经赞过'
          })
        }
      },

    })
  },
   sc:function(){
    wx.request({
      url: app.globalData.IP+"sc.do",
      data: {
        aid:that.data.id,
        userid:app.globalData.UID
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        if(res.data==1)
        {
          that.data.article.sc=true;
             that.setData({
               article:that.data.article
             })
        }else{
          wx.showToast({
             duration:2000,
             title:'已经收藏'
          })
        }
      },

    })
  },
   gz:function(){
    wx.request({
      url: app.globalData.IP+"gz.do",
      data: {
        aid:that.data.article.auid,
        userid:app.globalData.UID
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        if(res.data==1)
        {
          that.data.article.gz=true;
             that.setData({
               article:that.data.article
             })
        }else{
          wx.showToast({
             duration:2000,
             title:'已经关注'
          })
        }
      },

    })
  },
  rep:function(){
     wx.redirectTo({
       url: '/pages/replyPage/replyPage?aid='+that.data.article.id+"&title="+that.data.article.title+"&typ=2"+"&rtid="+that.data.article.id,
     })
  },
  rep2:function(e){
    var index=e.target.dataset.in;
          wx.redirectTo({
       url: '/pages/replyPage/replyPage?aid='+that.data.replace[index].id+"&title="+that.data.replace[index].title+"&typ=3"+"&rtid="+that.data.article.id,
     }) 
  }
})