(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0c55d5dd"],{2588:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=this,a=e.$createElement,n=e._self._c||a;return n("page-header-wrapper",[n("a-card",{attrs:{bordered:!1}},[n("div",{staticClass:"table-page-search-wrapper"},[n("a-form",{attrs:{layout:"inline"}},[n("a-row",{attrs:{gutter:48}},[n("a-col",{attrs:{md:8,sm:24}},[n("a-form-item",{attrs:{label:"设备ID"}},[n("a-input",{attrs:{placeholder:""},model:{value:e.queryParam.clientId,callback:function(t){e.$set(e.queryParam,"clientId",t)},expression:"queryParam.clientId"}})],1)],1),n("a-col",{attrs:{md:8,sm:24}},[n("a-form-item",{attrs:{label:"设备IP"}},[n("a-input",{attrs:{placeholder:""},model:{value:e.queryParam.address,callback:function(t){e.$set(e.queryParam,"address",t)},expression:"queryParam.address"}})],1)],1),e.advanced?void 0:e._e(),n("a-col",{attrs:{md:e.advanced?24:8,sm:24}},[n("span",{staticClass:"table-page-search-submitButtons",style:e.advanced&&{float:"right",overflow:"hidden"}||{}},[n("a-button",{attrs:{type:"primary"},on:{click:function(t){return e.$refs.table.refresh(!0)}}},[e._v("查询")]),n("a-button",{staticStyle:{"margin-left":"8px"},on:{click:function(){return t.queryParam={}}}},[e._v("重置")]),n("a",{staticStyle:{"margin-left":"8px"},on:{click:e.toggleAdvanced}},[e._v(" "+e._s(e.advanced?"收起":"展开")+" "),n("a-icon",{attrs:{type:e.advanced?"up":"down"}})],1)],1)])],2)],1)],1),n("div",{staticClass:"table-operator"}),n("s-table",{ref:"table",attrs:{size:"default",rowKey:"key",columns:e.columns,data:e.loadData,alert:!0,rowSelection:e.rowSelection,showPagination:"auto"},scopedSlots:e._u([{key:"serial",fn:function(t,a,s){return n("span",{},[e._v(" "+e._s(s+1)+" ")])}},{key:"action",fn:function(t,a){return n("span",{},[[n("a",{on:{click:function(t){return e.handleEdit(a)}}},[e._v("踢出")])]],2)}}])})],1)],1)},s=[],r=a("c1df"),c=a.n(r),o=a("2af9"),i=a("8593"),d=[{title:"#",scopedSlots:{customRender:"serial"}},{title:"客户端Id",dataIndex:"clientId"},{title:"用户",dataIndex:"user"},{title:"地址",dataIndex:"address"},{title:"连接时间",dataIndex:"connectTiem",sorter:!0},{title:"操作",dataIndex:"action",width:"150px",scopedSlots:{customRender:"action"}}],l={0:{status:"default",text:"关闭"},1:{status:"processing",text:"运行中"},2:{status:"success",text:"已上线"},3:{status:"error",text:"异常"}},u={name:"Clients",components:{STable:o["c"],Ellipsis:o["a"]},data:function(){var t=this;return this.columns=d,{advanced:!1,queryParam:{},loadData:function(e){var a=Object.assign({},e,t.queryParam);return Object(i["a"])(a).then((function(t){return t.data}))},selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(t){return l[t].text},statusTypeFilter:function(t){return l[t].status}},created:function(){},computed:{rowSelection:function(){return{selectedRowKeys:this.selectedRowKeys,onChange:this.onSelectChange}}},methods:{onSelectChange:function(t,e){this.selectedRowKeys=t,this.selectedRows=e},toggleAdvanced:function(){this.advanced=!this.advanced},resetSearchForm:function(){this.queryParam={date:c()(new Date)}}}},f=u,m=a("2877"),p=Object(m["a"])(f,n,s,!1,null,null,null);e["default"]=p.exports},8593:function(t,e,a){"use strict";a.d(e,"c",(function(){return r})),a.d(e,"a",(function(){return c})),a.d(e,"b",(function(){return o}));var n=a("b775"),s={Syteminfo:"/v1/system/info",Clients:"/v1/system/clients",Nodes:"/v1/system/nodes"};function r(){return Object(n["c"])({url:s.Syteminfo,method:"get"})}function c(t){return Object(n["c"])({url:s.Clients,method:"get",params:t})}function o(){return Object(n["c"])({url:s.Nodes,method:"get"})}}}]);