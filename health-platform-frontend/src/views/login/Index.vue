<template>
  <div class="login-page">
    <el-card class="login-card" shadow="always">
      <template #header>
        <div class="login-card__title">
          <h2>全球健康发展监测平台</h2>
          <p>Global Health Development Monitoring Platform</p>
        </div>
      </template>

      <el-form ref="formRef" :model="form" :rules="rules" label-width="0" size="large">
        <el-form-item prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" prefix-icon="User" />
        </el-form-item>

        <el-form-item prop="password">
          <el-input
            v-model="form.password"
            type="password"
            placeholder="请输入密码"
            prefix-icon="Lock"
            show-password
            @keyup.enter="handleLogin"
          />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" :loading="loading" style="width: 100%" @click="handleLogin">
            登 录
          </el-button>
        </el-form-item>

        <div class="login-card__footer">
          <span>还没有账号？</span>
          <el-link type="primary" :underline="false">立即注册</el-link>
        </div>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'

const formRef = ref<FormInstance>()
const loading = ref(false)

interface LoginForm {
  username: string
  password: string
}

const form = reactive<LoginForm>({
  username: '',
  password: ''
})

const rules: FormRules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
}

function handleLogin(): void {
  console.log('登录功能待实现 — 当前为骨架阶段')
}
</script>

<style scoped lang="scss">
.login-page {
  width: 420px;

  .login-card {
    border-radius: 12px;

    &__title {
      text-align: center;

      h2 {
        margin: 0 0 8px;
        color: $text-primary;
        font-size: 22px;
      }

      p {
        margin: 0;
        color: $text-secondary;
        font-size: 13px;
      }
    }

    &__footer {
      text-align: center;
      color: $text-secondary;
      font-size: 14px;
    }
  }
}
</style>
