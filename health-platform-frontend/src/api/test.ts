import request from './index'

/**
 * 测试接口 — 用于 S3 前后端联调验证
 */
export function getHello() {
  return request.get<string>('/hello')
}
