# 全球健康发展监测与分析平台 — 前端

## 启动步骤

### 方式一：npm

```bash
npm install
npm run dev
```

### 方式二：pnpm（推荐）

```bash
pnpm install
pnpm dev
```

### 方式三：yarn

```bash
yarn install
yarn dev
```

### 方式四：bun

```bash
bun install
bun run dev
```

> 四种方式等价，任选其一即可。启动后访问 `http://localhost:5173`，点击 Dashboard 首页的「测试后端连接」按钮验证前后端联调。

## 依赖说明

| 包 | 版本 | 用途 |
|---|------|------|
| vue | ^3.5 | 核心框架 |
| typescript | ~5.6 | 类型系统 |
| vue-router | ^4.5 | 路由管理 |
| pinia | ^2.3 | 状态管理 |
| element-plus | ^2.9 | UI 组件库 |
| echarts | ^5.5 | 图表可视化 |
| axios | ^1.7 | HTTP 请求 |

## 注意事项

- 后端需先启动在 `http://localhost:8080`
- Vite 已配置代理 `/api` → `http://localhost:8080`
- 骨架阶段 Security 放行所有接口，无需登录即可测试
- 全项目使用 TypeScript，`<script>` 标签统一为 `<script setup lang="ts">`
