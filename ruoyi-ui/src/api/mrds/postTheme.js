import request from '@/utils/request'

// 查询活动管理列表
export function listPostTheme(query) {
  return request({
    url: '/mrds/postTheme/list',
    method: 'get',
    params: query
  })
}

// 查询活动管理详细
export function getPostTheme(id) {
  return request({
    url: '/mrds/postTheme/' + id,
    method: 'get'
  })
}

// 新增活动管理
export function addPostTheme(data) {
  return request({
    url: '/mrds/postTheme',
    method: 'post',
    data: data
  })
}

// 修改活动管理
export function updatePostTheme(data) {
  return request({
    url: '/mrds/postTheme',
    method: 'put',
    data: data
  })
}

// 删除活动管理
export function delPostTheme(id) {
  return request({
    url: '/mrds/postTheme/' + id,
    method: 'delete'
  })
}
