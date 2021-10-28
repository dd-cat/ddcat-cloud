#!/usr/bin/env python
# coding: utf-8
import os

import requests

address = 'http://192.168.164.128:8848/nacos'
username = 'nacos'
password = 'nacos'


def create_namespace(id, name):
    """创建命名空间

    :param id: 命名空间 ID
    :param name: 命名空间名称
    :return: 是否请求成功
    """
    return requests.post('{}/v1/console/namespaces'.format(address),
                         {'username': username,
                          'password': password,
                          'customNamespaceId': id,
                          'namespaceName': name
                          }).text == 'true'


def push_config(tenant, name, content, nacos_group, nacos_type):
    """推送配置

    :param tenant: 命名空间 ID
    :param name: 配置名称
    :param content: 配置内容
    :param nacos_group: 分组名称
    :param nacos_type: 配置类型
    :return: 是否请求成功
    """
    return requests.post('{}/v1/cs/configs'.format(address),
                         {
                             'username': username,
                             'password': password,
                             'dataId': name,
                             'tenant': tenant,
                             'content': content,
                             'group': nacos_group,
                             'type': nacos_type
                         }
                         ).text == 'true'


if __name__ == '__main__':
    if create_namespace('privateId', 'private'):
        print('创建项目命名空间成功')
    if create_namespace('privateDubboId', 'privateDubbo'):
        print('创建 Dubbo 命名空间成功')
    for dir in os.listdir():
        if dir != 'nacos-config.py':
            with open(dir, encoding='utf8') as f:
                # 推送配置
                if push_config('privateId', dir, f.read(),
                               'DEFAULT_GROUP', dir[dir.rfind('.') + 1:]):
                    print('推送' + dir + '配置成功')
