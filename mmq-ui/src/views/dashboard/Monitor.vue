<template>
  <page-header-wrapper>
    <div style="background: #ececec; padding: 10px">
      <a-row :gutter="24">
        <a-col :span="6">
          <a-card>
            <a-statistic
              title="版本"
              :value="SystemInfoMateData.version"
              class="demo-class"
              :value-style="{ color: '#3f8600', fontSize: '32px' }"
            >
              <template #prefix>
                <a-icon type="smile" theme="twoTone" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card>
            <a-statistic
              title="系统时间"
              :value="dateTime"
              class="demo-class"
              :value-style="{ color: '#3f8600', fontSize: '28px' }"
            >
              <template #prefix>
                <a-icon type="smile" theme="twoTone" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card>
            <a-statistic
              title="连接数"
              :value="SystemInfoMateData.clientCount"
              class="demo-class"
              :value-style="{ color: 'hotpink', fontSize: '32px' }"
            >
              <template #prefix>
                <a-icon type="smile" theme="twoTone" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card>
            <a-statistic
              title="订阅数"
              :value="SystemInfoMateData.subscribeCount"
              class="demo-class"
              :value-style="{ color: '#52c41a', fontSize: '32px' }"
            >
              <template #prefix>
                <a-icon type="smile" theme="twoTone" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
      </a-row>
    </div>
    <a-card style="ma" :bordered="false">
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="节点">
                <a-select size="large" placeholder="请选择节点" v-model="node">
                  <a-select-option v-for="item in nodeList" :key="item.address" :value="item.address">{{
                    item.address
                  }}</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
        </a-form>
      </div>
      <a-tabs default-active-key="1">
        <a-tab-pane key="1" tab="基本信息"> <SystemInfo :nodeUrl="node"></SystemInfo> </a-tab-pane>
        <a-tab-pane key="2" tab="Tomact信息"> <TomcatInfo :nodeUrl="node"></TomcatInfo> </a-tab-pane>
        <a-tab-pane key="3" tab="JVM信息"> <JvmInfo :nodeUrl="node"></JvmInfo> </a-tab-pane>
        <a-tab-pane key="4" tab="HTTP追踪">
          <HttpTrace :nodeUrl="node"></HttpTrace>
        </a-tab-pane>
      </a-tabs>
    </a-card>
  </page-header-wrapper>
</template>

<script>
import moment from 'moment'
import { getSystemInfo, getNodes } from '@/api/system'
import HttpTrace from './module/HttpTrace'
import JvmInfo from './module/JvmInfo'
import SystemInfo from './module/SystemInfo'
import TomcatInfo from './module/TomcatInfo'

export default {
  name: 'Monitor',
  components: {
    HttpTrace,
    JvmInfo,
    SystemInfo,
    TomcatInfo
  },
  data () {
    return {
      dateTime: moment(new Date()).format('YYYY-MM-DD'),
      node: '',
      nodeList: [],
      SystemInfoMateData: {
        clientCount: 0,
        systemRunTime: 0,
        version: '',
        systemName: '',
        subscribeCount: 0
      }
    }
  },
  created () {

  },
  mounted () {
    const _this = this // 声明一个变量指向Vue实例this，保证作用域一致
    this.timer = setInterval(() => {
      _this.dateTime = moment(new Date()).format('YYYY-MM-DD HH:mm:ss') // 修改数据date
    }, 1000)

    getNodes().then(res => {
      this.nodeList = res.data
      this.node = res.data[0].address
    })

    getSystemInfo().then(res => {
      console.log(res)
      this.SystemInfoMateData = res.data
    })
  },
  methods: {

  }
}
</script>

<style scoped>
</style>
