// pages/community/community.js
Page({
  data:{
    swiperCurrent:0,
    communityFocusCurrent:0,
     replyAvtive:true,
    releaseAvtive:false,
    concernCancelflag:true,
     slider: [
      '/images/community.jpg',
      '/images/community.jpg',
      '/images/community.jpg'
    ],
  icon1:[
      {
        img:'../../images/baoliao.jpg',
        text:'我要爆料'
      },
           {
        img:'../../images/job.jpg',
        text:'我要求职'
      },
           {
        img:'../../images/home.jpg',
        text:'房屋出售'
      },
           {
        img:'../../images/baby.jpg',
        text:'家有萌娃'
      },
           {
        img:'../../images/talk.jpg',
        text:'大话海滨'
      },
           {
        img:'../../images/jiaoyi.jpg',
        text:'闲置交易'
      },
           {
        img:'../../images/yuanfen.jpg',
        text:'缘在滨海'
      },
           {
        img:'../../images/eat.jpg',
        text:'滨海吃货'
      }
  ],
  icon2:[
      {
        img:'../../images/fzone.jpg',
        text:'滨海拍客'
      },
           {
        img:'../../images/medicalEducation.jpg',
        text:'教育医疗'
      },
           {
        img:'../../images/activity.jpg',
        text:'滨海活动'
      },
           {
        img:'../../images/traffic.jpg',
        text:'滨海交通'
      },
           {
        img:'../../images/riders.jpg',
        text:'滨海车友'
      },
           {
        img:'../../images/emotionSpace.jpg',
        text:'情感空间'
      },
           {
        img:'../../images/business.jpg',
        text:'创业滨海'
      },
           {
        img:'../../images/pet.jpg',
        text:'我的萌宠'
      }
  ]
  },
  //滑块指示
    swiperChange:function(e){
      console.log(e.detail.current)
        this.setData({
    swiperCurrent: e.detail.current
  })
},
  //滑块指示
    communityFocusChange:function(e){
      console.log(e.detail.current)
        this.setData({
    communityFocusCurrent: e.detail.current
  })
},
//选项卡切换
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
    wx.setNavigationBarTitle({
      title: '滨海圈',
      success: function(res) {
        // success
      }
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