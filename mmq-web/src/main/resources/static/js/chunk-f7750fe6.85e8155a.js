(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f7750fe6"],{"0b56":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("page-header-wrapper",[a("div",{staticStyle:{background:"#ececec",padding:"30px"}},[a("a-row",{attrs:{gutter:24}},[a("a-col",{attrs:{span:6}},[a("a-card",[a("a-statistic",{staticStyle:{"margin-right":"50px"},attrs:{title:"系统名称",value:t.SystemInfoMateData.systemName,precision:2,"value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-bottom"}})]},proxy:!0}])})],1)],1),a("a-col",{attrs:{span:6}},[a("a-card",[a("a-statistic",{staticClass:"demo-class",attrs:{title:"版本",value:t.SystemInfoMateData.version,"value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-horizontal"}})]},proxy:!0}])})],1)],1),a("a-col",{attrs:{span:6}},[a("a-card",[a("a-statistic",{staticClass:"demo-class",attrs:{title:"运行时间",value:t.SystemInfoMateData.systemRunTime+"ms","value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-outer"}})]},proxy:!0}])})],1)],1),a("a-col",{attrs:{span:6}},[a("a-card",[a("a-statistic",{staticClass:"demo-class",attrs:{title:"系统时间",value:t.dateTime,"value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-inner"}})]},proxy:!0}])})],1)],1)],1),a("a-row",{attrs:{gutter:24}},[a("a-col",{attrs:{span:12}},[a("a-card",[a("a-statistic",{staticClass:"demo-class",attrs:{title:"连接数",value:t.SystemInfoMateData.clientCount,"value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-inner"}})]},proxy:!0}])})],1)],1),a("a-col",{attrs:{span:12}},[a("a-card",[a("a-statistic",{staticClass:"demo-class",attrs:{title:"订阅数",value:t.SystemInfoMateData.subscribeCount,"value-style":{color:"#3f8600"}},scopedSlots:t._u([{key:"prefix",fn:function(){return[a("a-icon",{attrs:{type:"border-inner"}})]},proxy:!0}])})],1)],1)],1)],1)])},r=[],n=a("c1df"),o=a.n(n),i=a("8593"),c={name:"Monitor",data:function(){return{dateTime:o()(new Date).format("YYYY-MM-DD"),SystemInfoMateData:{clientCount:0,systemRunTime:0,version:"",systemName:"",subscribeCount:0}}},created:function(){},mounted:function(){var t=this,e=this;this.timer=setInterval((function(){e.dateTime=o()(new Date).format("YYYY-MM-DD HH:mm:ss")}),1e3),Object(i["b"])().then((function(e){t.SystemInfoMateData=e.data}))},methods:{}},l=c,u=a("2877"),f=Object(u["a"])(l,s,r,!1,null,"91a18050",null);e["default"]=f.exports},8593:function(t,e,a){"use strict";a.d(e,"b",(function(){return n})),a.d(e,"a",(function(){return o}));var s=a("b775"),r={Syteminfo:"/v1/system/info",Clients:"/v1/system/clients"};function n(){return Object(s["b"])({url:r.Syteminfo,method:"get"})}function o(t){return Object(s["b"])({url:r.Clients,method:"get",params:t})}}}]);