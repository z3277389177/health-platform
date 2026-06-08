<template>
  <el-container class="default-layout">
    <!-- 侧边栏 -->
    <el-aside :width="isCollapse ? '64px' : '220px'" class="sidebar">
      <div class="sidebar__logo">
        <span v-show="!isCollapse">健康监测平台</span>
        <span v-show="isCollapse">HP</span>
      </div>
      <el-menu
        :collapse="isCollapse"
        :default-active="route.path"
        router
        background-color="#001529"
        text-color="#ffffffa6"
        active-text-color="#ffffff"
      >
        <el-menu-item index="/dashboard">
          <el-icon><DataAnalysis /></el-icon>
          <template #title>全球概览</template>
        </el-menu-item>

        <el-sub-menu index="viz">
          <template #title>
            <el-icon><TrendCharts /></el-icon>
            <span>数据可视化</span>
          </template>
          <el-menu-item index="/viz/map">世界地图</el-menu-item>
          <el-menu-item index="/viz/bubble">气泡动画</el-menu-item>
          <el-menu-item index="/viz/indicator">指标探索</el-menu-item>
          <el-menu-item index="/viz/compare">国家对比</el-menu-item>
          <el-menu-item index="/viz/trend">趋势追踪</el-menu-item>
          <el-menu-item index="/viz/ranking">排行榜单</el-menu-item>
          <el-menu-item index="/viz/distribution">分布统计</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="ai">
          <template #title>
            <el-icon><MagicStick /></el-icon>
            <span>智能分析</span>
          </template>
          <el-menu-item index="/ai/chat">智能问答</el-menu-item>
          <el-menu-item index="/ai/predict">趋势预测</el-menu-item>
          <el-menu-item index="/ai/report">分析报告</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="admin" v-if="isAdmin">
          <template #title>
            <el-icon><Setting /></el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item index="/admin/user">用户管理</el-menu-item>
          <el-menu-item index="/admin/data">数据管理</el-menu-item>
          <el-menu-item index="/admin/indicator">指标管理</el-menu-item>
          <el-menu-item index="/admin/notice">公告管理</el-menu-item>
          <el-menu-item index="/admin/ai-knowledge">AI知识库</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>

    <!-- 右侧区域 -->
    <el-container>
      <!-- 顶栏 -->
      <el-header class="header">
        <div class="header__left">
          <el-icon class="collapse-btn" @click="isCollapse = !isCollapse">
            <Fold v-if="!isCollapse" />
            <Expand v-else />
          </el-icon>
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>{{ currentMenu }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="header__right">
          <el-dropdown>
            <span class="user-info">
              <el-avatar :size="28">{{ userInfo.username?.charAt(0)?.toUpperCase() || 'U' }}</el-avatar>
              <span class="username">{{ userInfo.username || '用户' }}</span>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人中心</el-dropdown-item>
                <el-dropdown-item divided @click="handleLogout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>

      <!-- 内容区 -->
      <el-main class="main">
        <RouterView />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useUserStore } from '@/stores/user'

const route = useRoute()
const router = useRouter()
const userStore = useUserStore()

const isCollapse = ref(false)
const isAdmin = ref(true) // 骨架阶段默认显示，后续根据角色控制

const userInfo = computed(() => userStore.userInfo)

const menuNameMap: Record<string, string> = {
  '/dashboard': '全球概览',
  '/viz/map': '世界地图热力图',
  '/viz/bubble': '气泡动画图表',
  '/viz/indicator': '指标详情探索',
  '/viz/compare': '国家多维对比',
  '/viz/trend': '时间趋势追踪',
  '/viz/ranking': '排行榜单',
  '/viz/distribution': '饼图分布统计',
  '/ai/chat': '智能问答',
  '/ai/predict': '趋势预测',
  '/ai/report': '分析报告'
}

const currentMenu = computed(() => menuNameMap[route.path] || '全球概览')

function handleLogout(): void {
  userStore.logout()
  router.push('/login')
}
</script>

<style scoped lang="scss">
.default-layout {
  height: 100vh;
}

.sidebar {
  background-color: #001529;
  transition: width 0.3s;
  display: flex;
  flex-direction: column;

  &__logo {
    height: $header-height;
    flex-shrink: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 18px;
    font-weight: bold;
    color: #fff;
    background-color: #002140;
    overflow: hidden;
    white-space: nowrap;
  }

  .el-menu {
    border-right: none;
    flex: 1;
    overflow-y: auto;
  }
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 1px solid $border-color;
  padding: 0 20px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.05);

  &__left {
    display: flex;
    align-items: center;
    gap: 16px;

    .collapse-btn {
      cursor: pointer;
      font-size: 20px;
    }
  }

  &__right {
    .user-info {
      display: flex;
      align-items: center;
      gap: 8px;
      cursor: pointer;

      .username {
        font-size: 14px;
        color: $text-primary;
      }
    }
  }
}

.main {
  background-color: $bg-page;
  padding: 20px;
}
</style>
