# pip install bs4

# encoding: utf-8
import requests
from bs4 import BeautifulSoup
import json
import time


def crawl_detail(id):
    url = 'https://www.lagou.com/jobs/%s.html' % id
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36',
        'Host': 'www.lagou.com',
        'Referer': 'https://www.lagou.com/jobs/list_Python?city=%E5%8C%97%E4%BA%AC&cl=false&fromSearch=true&labelWords=&suginput=',
        'Upgrade-Insecure-Requests': '1'
    }

    req = requests.get(url, headers=headers)
    soup = BeautifulSoup(req.content)
    jb_bt = soup.find('dd', attrs={'class': 'job_bt'})
    # find_all返回所有数据，find返回符合数据的第一条数据
    print(jb_bt.text)


def main():
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36',
        'Host': 'www.lagou.com',
        'Referer': 'https://www.lagou.com/jobs/list_Python?city=%E5%8C%97%E4%BA%AC&cl=false&fromSearch=true&labelWords=&suginput=',
        'X-Anit-Forge-Code': '0',
        'X-Anit-Forge-Token': None,
        'X-Requested-With': 'XMLHttpRequest',
        'Accept-Language': 'zh-CN,zh;q=0.9',
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    }
    # form_data = {
    #     'first': 'true',
    #     'pn': '1',
    #     'kd': 'Python'
    # }

    # result = requests.post(
    #     'https://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC&needAddtionalResult=false&isSchoolJob=0',
    #     headers=headers, data=form_data)
    # json_result = result.json()
    # positions = json_result['content']['positionResult']['result']

    # line = json.dumps(positions, ensure_ascii=False)
    # with open('lagou.json', 'wb+') as fp:
    #     fp.write(line.encode('utf-8'))

    # for position in positions:
    #     print('-' * 40)
    #     print(position)
    positions = []
    for x in range(1, 31):
        form_data = {
            'first': 'true',
            'pn': x,
            'kd': 'Python'
        }
        result = requests.post(
            'https://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC&needAddtionalResult=false&isSchoolJob=0',
            headers=headers, data=form_data)
        json_result = result.json()
        print('_' * 30)
        print(json_result)
        print('_' * 30)
        page_positions = json_result['content']['positionResult']['result']
        for position in page_positions:
            position_dict = {
                'position_name': position['positionName'],
                'work_year': position['workYear'],
                'salary': position['salary'],
                'district': position['district'],
                'company_name': position['companyFullName']
            }
            position_id = position['positionId']
            position_detail = crawl_detail(position_id)
            position_dict['position_detail'] = position_detail
            positions.append(position_dict)

    # '您操作太频繁,请稍后再访问'
    # 1.把sleep时间改大一点
    # 2.每次请求不要请求这么多，分多次请求
    time.sleep(3)


# line = json.dumps(positions, ensure_ascii=False)
# with open('lagou.json', 'wb+') as fp:
#     fp.write(line.encode('utf-8'))

if __name__ == '__main__':
    # main()
    crawl_detail('3460224')
