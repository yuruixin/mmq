import request from '@/utils/request'

const systemApi = {
    Syteminfo: '/v1/system/info',
    Clients: '/v1/system/clients',
    Nodes: '/v1/system/nodes'
}

export function getSystemInfo () {
    return request({
        url: systemApi.Syteminfo,
        method: 'get'
    })
}

export function getClients (parameter) {
    return request({
        url: systemApi.Clients,
        method: 'get',
        params: parameter
    })
}

export function getNodes () {
    return request({
        url: systemApi.Nodes,
        method: 'get'
    })
}
