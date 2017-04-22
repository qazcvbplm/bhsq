//index.js
var that;
var app=getApp();
const ImgLoader = require('../../img-loader/img-loader.js')
Page({
  data: {
    //成长值
    qd:true,
    GrowthValue:5,
    swiperCurrent:0,
    signHidden:false,
    SuccessFlag:false,
    //图标信息
    slider: [
      '/images/focus_01.jpg',
      '/images/focus_01.jpg',
      '/images/focus_01.jpg'
    ],
     swiperCurrent: 0,
    icon:[
  
    ],
    change:function(e){
      console.log(1)
    },


     //滑块指示
    swiperChange:function(e){
      console.log(e.detail.current)
        this.setData({
    swiperCurrent: e.detail.current
  })
},
    //头条
    handLineTitle:"今日头条",
    handLineContentText:'滨海县通榆舀港三天一集，严重影响张沟、陈铸、正红15万人通行。',
    handLineContentAuthor:'张三',
    readNum:123,
    releaseTime:5,

    //大家都在聊
    talkingsTitle:'大家都在聊',
    talkings:[
 
    ],
    //热门推荐
    hot:'热门推荐',
  },

  //轮播图
  swiperChange:function(e){
  this.setData({
    swiperCurrent: e.detail.current
  })
},
  //关闭签到
  closeSign:function(){
    this.setData({
      signHidden:false
    })
  },
  //签到成功
  signSuccess:function(){
    var that = this;
    wx.request({
      url: app.globalData.IP+"userqd.do",
      data: {userid:app.globalData.UID},
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
         if(res.data==1)
         {
              that.setData({
            SuccessFlag:!that.data.SuccessFlag,
            qd:true
          })
          setTimeout(function() {   
            that.setData({
                SuccessFlag:!that.data.SuccessFlag
            })    
            }, 1000)
         }
      },
    })
  },   
  //跳转到商业资讯
  information:function(e){
    wx.navigateTo({
      url: '/pages/information/information?id='+e.currentTarget.id,
     
    })
  },
  //跳转到8个列表的详情页
  brokeNews:function(e){
    //获取当前点击元素的id
    var index = e.currentTarget.id;
    //获取当前点击元素的text值
    var TheTitle = this.data.icon[index].text;
       console.log(this.data.icon[index].text)
    wx.navigateTo({
      url: '/pages/brokeNews/brokeNews',
      success: function(res){
        //设置标题
        wx.setNavigationBarTitle({
          title: TheTitle,
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
  succ:function(err,data){
                         for(var i=0;i<that.data.tt.length;i++)
                         {
                               for(var j=0;j<that.data.tt[i].image.length-1;j++)
                               {
                                 if(data.src==that.data.tt[i].image[j])
                                 {
                                   that.data.tt[i].timage[j]=data.src;
                                   that.setData({tt:that.data.tt});
                                 }
                               }
                         }
                          for(var i=0;i<that.data.dj.length;i++)
                         {
                               for(var j=0;j<that.data.dj[i].image.length;j++)
                               {
                                 if(data.src==that.data.dj[i].image[j])
                                 {
                                   that.data.dj[i].timage[j]=data.src;
                                   that.setData({dj:that.data.dj});
                                 }
                               }
                         }
                            for(var i=0;i<that.data.rm.length;i++)
                         {
                               for(var j=0;j<that.data.rm[i].image.length-1;j++)
                               {
                                 if(data.src==that.data.rm[i].image[j])
                                 {
                                   that.data.rm[i].timage[j]=data.src;
                                   that.setData({rm:that.data.rm});
                                 }
                               }
                         }
  },
  getUserInfo:function(){
    var that = this
   
      //调用登录接口
      wx.login({
        success: function (res2) {
          wx.getUserInfo({
            success: function (res) {
              app.globalData.userInfo = res.userInfo
              wx.request({
             url: app.globalData.IP+"login.do",
             data: {
               code:res2.code,
               name:app.globalData.userInfo.nickName,
               head:app.globalData.userInfo.avatarUrl
             },
             method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
             // header: {}, // 设置请求的 header
             header:{'content-type':'application/x-www-form-urlencoded'},
             success: function(res){
               // success
               if(res.data.id)
               {
                 app.globalData.UID=res.data.id;
                  app.globalData.qd=res.data.qd;
                  that.setData({
                    qd:res.data.qd
                  })
               }
             },
           })
            }
          })
        }
      })
    
  },
  onLoad:function(){
     that=this;
     that.getUserInfo();
      this.imgLoader = new ImgLoader(this,this.succ.bind(this));
     //请求板块数据
     wx.request({
       url: app.globalData.url+"platelistajax.do",
       data: {},
       method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
       // header: {}, // 设置请求的 header
       success: function(res){
         // success
         for(var i=0;i<res.data.length;i++)
         {
           var item={id:res.data[i].id,text:res.data[i].name,img:app.globalData.url2+res.data[i].image,visitor:res.data[i].visitor};
           that.data.icon.push(item);
         }
         that.setData({
           icon:that.data.icon
         })
       },
     });
     wx.request({
       url: app.globalData.IP+"index.do",
       data: {},
       method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
       // header: {}, // 设置请求的 header
       success: function(res){
         // success
          
         var rm=res.data.rm;
         var temptt=res.data.td;
         var tempdj=res.data.dj;
         var rs=[];
         var tt=[];
         var dj=[];
         for(var i=0;i<rm.length;i++)
         {
           //加载热门数据
           var item={id:rm[i].id,title:rm[i].title,image:rm[i].image.split(","),visitor:rm[i].visitor,time:rm[i].time,timage:rm[i].image.split(",")};
           for(var j=0;j<item.image.length-1;j++)
           {
             item.timage[j]=app.globalData.url+item.image[j].replace("u","a").replace("u","a").replace("a","u");
             item.image[j]=app.globalData.url+item.image[j];
           }
           if(rm[i].userid==0)
           item.writer="管理员";
           else
           item.writer=rm[i].user.name;
           rs.push(item);
           //加载今日头条数据
           if(i<temptt.length)
           {
              var item2={id:temptt[i].id,title:temptt[i].title,image:temptt[i].image.split(","),visitor:temptt[i].visitor,time:temptt[i].time,timage:[]};
                    for(var j=0;j<item2.image.length-1;j++)
              {
                item2.timage[j]=app.globalData.url+item2.image[j].replace("u","a").replace("u","a").replace("a","u");
                item2.image[j]=app.globalData.url+item2.image[j];
              }
                 if(temptt[i].userid==0)
                  item2.writer="管理员";
                  else
                  item2.writer=rm[i].user.name;
                  tt.push(item2);
           }
           //加载大家都在聊
                if(i<tempdj.length)
           {
              var item3={replace:tempdj[i].replace,id:tempdj[i].id,title:tempdj[i].title,image:tempdj[i].image.split(","),visitor:tempdj[i].visitor,time:tempdj[i].time,timage:[]};
                    for(var j=0;j<item3.image.length-1;j++)
                   {
                item3.timage[j]=app.globalData.url+item3.image[j].replace("u","a").replace("u","a").replace("a","u");
                item3.image[j]=app.globalData.url+item3.image[j];
                   }
                 if(tempdj[i].userid==0)
                  item3.writer="管理员";
                  else
                  item3.writer=rm[i].user.name;
                  dj.push(item3);
           }
         }
         that.setData({
           rm:rs,
           tt:tt,
           dj:dj
         })     
          
          //预加载
          that.yjz();
      
          
       },
     })
  },
  yjz:function(){
                    //预加载
           that.data.tt.forEach(item => {
              item.image.forEach(item => {
                 if(item!='')
                 {
                     that.imgLoader.load(item)
                 }
              })
          })
            //预加载
           that.data.dj.forEach(item => {
              item.image.forEach(item => {
                 if(item!='')
                 {
                     that.imgLoader.load(item)
                 }
              })
          })
          //预加载
           that.data.rm.forEach(item => {
              item.image.forEach(item => {
                 if(item!='')
                 {
                     that.imgLoader.load(item)
                 }
              })
          })
          
          
        
  },
})
