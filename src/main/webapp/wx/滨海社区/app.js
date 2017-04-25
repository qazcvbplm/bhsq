//app.js
App({
  onLaunch: function () {
    //调用API从本地缓存中获取数据
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
  },
  
  globalData:{
     userInfo:null,
     IP:'http://192.168.1.114:8080/bhsq/wx/',
     url:'http://192.168.1.114:8080/bhsq/',
     url2:'http://112.74.110.66:8080/upload/',
     UID:0,
     qd:true
  }
})