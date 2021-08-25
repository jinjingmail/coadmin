import request from '@/utils/request'

/*
 * ${apiAlias}
 */

export function add(data) {
  return request({
    url: 'api/${subModuleName}/${minusClassName}',
    method: 'post',
    data
  })
}

export function del(ids) {
  return request({
    url: 'api/${subModuleName}/${minusClassName}',
    method: 'delete',
    data: ids
  })
}

export function edit(data) {
  return request({
    url: 'api/${subModuleName}/${minusClassName}',
    method: 'put',
    data
  })
}

export default { add, edit, del }
