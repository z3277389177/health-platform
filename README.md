<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=32&duration=3000&pause=1000&color=2E8B57&center=true&vCenter=true&width=600&lines=Global+Health+Platform;全球健康发展监测与分析平台" alt="Title">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.3.5-6DB33F?style=flat-square&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Vue-3.5-4FC08D?style=flat-square&logo=vuedotjs&logoColor=white" alt="Vue 3">
  <img src="https://img.shields.io/badge/TypeScript-5.6-3178C6?style=flat-square&logo=typescript&logoColor=white" alt="TypeScript">
  <img src="https://img.shields.io/badge/ECharts-5.5-AA344D?style=flat-square&logo=apacheecharts&logoColor=white" alt="ECharts">
  <img src="https://img.shields.io/badge/MySQL-8-4479A1?style=flat-square&logo=mysql&logoColor=white" alt="MySQL">
</p>

<p align="center">
  <strong>🌍 A data-driven platform for monitoring & analyzing global health development trends</strong><br>
  <strong>基于 Gapminder 开放数据，以可视化驱动洞察的健康发展监测平台</strong>
</p>

---

## 📖 简介 | Overview

基于 **Gapminder Systema Globalis**（528 指标 / 273 国家 / 200+ 年）开放数据构建的全球健康发展监测平台。通过多维度可视化图表、智能分析引擎与交互式探索工具，将复杂数据转化为直观洞见。

Built on **Gapminder Systema Globalis** open data (528 indicators × 273 countries × 200+ years). Transforms complex global health data into actionable insights through multi-dimensional visualization, AI-powered analysis, and interactive exploration.

## ✨ 核心功能 | Features

| 模块 | Module | 说明 |
|------|--------|------|
| 🗺️ **世界地图热力图** | Choropleth Map | 指标/年份选择器，连续 & 分级色阶切换 |
| 🫧 **气泡动画图表** | Bubble Chart | X/Y/Size/Color 四维选择器，Timeline 播放控制 |
| 📊 **指标详情探索** | Indicator Explorer | 地图 / 排行 / 趋势 / 分布四视图联动 |
| 🔍 **国家多维对比** | Country Comparison | 雷达图 + 分组柱状图 + 差异表格 |
| 📈 **时间趋势追踪** | Trend Tracker | 多指标折线图 + CAGR 标注 + 预测延伸线 |
| 🏆 **排行榜单** | Ranking | 排名 / 国旗 / 数值 / 同比，支持关注置顶 |
| 🥧 **分布统计** | Distribution | 大洲 / 收入 / 性别维度下钻，玫瑰图模式 |
| 🤖 **智能问答** | NL2Query | 自然语言查询 → 自动图表推荐 + SSE 流式输出 |
| 📄 **分析报告** | Report Generator | 向导式配置 → HTML/PDF 导出 |

## 🏗️ 技术架构 | Tech Stack

```
┌─────────────────────────────────────────────────────┐
│                    Frontend                         │
│   Vue 3 · TypeScript · Vite · Element Plus         │
│   ECharts 5 · Pinia · Vue Router                   │
└──────────────────────┬──────────────────────────────┘
                       │ REST API
┌──────────────────────▼──────────────────────────────┐
│                    Backend                          │
│   Spring Boot 3.3.5 · MyBatis-Plus · MySQL 8       │
│   Spring Security · JWT · Commons CSV              │
└─────────────────────────────────────────────────────┘
```

## 🚀 快速开始 | Quick Start

### 前置要求 | Prerequisites

- JDK 17+
- Node.js 18+ / Bun / pnpm
- MySQL 8.0+

### 启动步骤 | Setup

```bash
# 1. 克隆项目
git clone https://github.com/z3277389177/health-platform.git
cd health-platform

# 2. 后端：创建数据库并启动
mysql -u root -p -e "CREATE DATABASE health_platform DEFAULT CHARSET utf8mb4;"
cd health-platform-backend
mvn spring-boot:run
# → http://localhost:8080/api/hello

# 3. 前端：安装依赖并启动（任选一种）
cd ../health-platform-frontend
bun install && bun run dev    # 推荐
# 或 pnpm install && pnpm dev
# 或 npm install && npm run dev
# → http://localhost:5173
```

### 项目结构 | Structure

```
health-platform/
├── health-platform-backend/     # Spring Boot 后端
│   └── src/main/java/
│       └── com/healthplatform/
│           ├── common/          # 公共模块（Result/异常/配置/JWT）
│           └── controller/      # 控制器层
├── health-platform-frontend/    # Vue 3 前端
│   └── src/
│       ├── api/                # Axios 封装 & 接口定义
│       ├── assets/styles/      # SCSS 变量 & 全局样式
│       ├── layouts/            # 管理端布局 & 登录布局
│       ├── router/             # 路由配置
│       ├── stores/             # Pinia 状态管理
│       └── views/              # 页面组件
└── README.md
```

## 📊 数据源 | Data Source

> [Gapminder Systema Globalis](https://systema.globalis.org/) — 全球最全面的公开社会发展指标数据库之一

首批核心指标（7 个）：

| Indicator | Description |
|-----------|-------------|
| `life_expectancy` | 预期寿命 |
| `infant_mortality` | 婴儿死亡率 |
| `population_total` | 总人口 |
| `gdp_per_capita` | 人均 GDP |
| `hiv_prevalence` | HIV 感染率 |
| `water_access` | 安全饮用水覆盖率 |
| `health_expenditure` | 医疗支出占比 |

## 📋 开发进度 | Progress

- [x] S1 — Spring Boot 骨架搭建
- [x] S2 — Vue 3 前端骨架搭建
- [ ] S3 — 前后端联调验证
- [ ] S4 — ER 图设计 & 建表
- [ ] S5-S27 — 功能开发中...

## 📄 许可证 | License

本项目为**毕业设计作品**，仅供学习交流。

This is a **graduation thesis project** for educational purposes only.

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/z3277389177">z3277389177</a>
</p>
