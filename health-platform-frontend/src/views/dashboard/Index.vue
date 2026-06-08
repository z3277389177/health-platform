<template>
  <div class="dashboard-page">
    <!-- 欢迎卡片 -->
    <el-row :gutter="16" class="welcome-section">
      <el-col :span="24">
        <el-card shadow="hover">
          <div class="welcome-text">
            <h2>🌍 全球健康发展监测与分析平台</h2>
            <p>基于 Gapminder 开放数据的可视化智能服务平台</p>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 联调验证区 — S3 前后端通信测试 -->
    <el-row :gutter="16" style="margin-top: 16px;">
      <el-col :span="24">
        <el-card shadow="hover">
          <template #header>
            <div class="card-header">
              <span>系统状态</span>
              <el-button type="primary" size="small" :loading="testing" @click="testConnection">
                测试后端连接
              </el-button>
            </div>
          </template>

          <el-descriptions :column="2" border>
            <el-descriptions-item label="前端状态">
              <el-tag type="success">运行中 (Vue 3 + Vite + TS)</el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="后端状态">
              <el-tag :type="backendStatus === 'connected' ? 'success' : backendStatus === 'error' ? 'danger' : 'info'">
                {{ backendStatusText }}
              </el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="后端响应">
              <span :class="{ 'response-ok': backendData }">{{ backendData || '等待测试...' }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="接口地址">
              <code>/api/hello</code>
            </el-descriptions-item>
          </el-descriptions>
        </el-card>
      </el-col>
    </el-row>

    <!-- 占位提示 — 后续在此添加 KPI 卡片和图表 -->
    <el-row :gutter="16" style="margin-top: 16px;">
      <el-col :span="8" v-for="i in 3" :key="i">
        <el-card shadow="hover" class="placeholder-card">
          <el-skeleton :rows="4" animated />
          <div class="placeholder-label">KPI 卡片 {{ i }}（后续实现）</div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { getHello } from '@/api/test'

type BackendStatus = 'idle' | 'connected' | 'error'

const testing = ref(false)
const backendStatus = ref<BackendStatus>('idle')
const backendStatusText = ref('未连接')
const backendData = ref('')

async function testConnection(): Promise<void> {
  testing.value = true
  backendStatus.value = 'idle'
  backendData.value = ''
  try {
    const res = await getHello()
    backendStatus.value = 'connected'
    backendStatusText.value = '已连接'
    backendData.value = res.data
  } catch (e: unknown) {
    backendStatus.value = 'error'
    backendStatusText.value = '连接失败'
    backendData.value = e instanceof Error ? e.message : String(e)
  } finally {
    testing.value = false
  }
}
</script>

<style scoped lang="scss">
.welcome-section {
  .welcome-text {
    h2 { margin: 0; color: $text-primary; }
    p { margin: 8px 0 0; color: $text-secondary; font-size: 14px; }
  }
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.response-ok {
  color: $success-color;
  font-weight: bold;
}

.placeholder-card {
  position: relative;

  .placeholder-label {
    position: absolute;
    bottom: 10px;
    left: 50%;
    transform: translateX(-50%);
    color: $text-placeholder;
    font-size: 13px;
  }
}
</style>
