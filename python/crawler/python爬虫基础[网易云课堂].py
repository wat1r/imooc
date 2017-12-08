
# coding: utf-8

# In[3]:


import requests
from bs4 import BeautifulSoup
res =requests.get("http://news.sina.com.cn/gov/2017-12-07/doc-ifypnqvn0946790.shtml")
res.encoding='utf-8'
print(res.text)
soup = BeautifulSoup(res.text,'html.parser')


# In[6]:


soup.select('#artibodyTitle')[0].text


# In[15]:


timesource=soup.select('.time-source')[0].contents[0].strip()
#type(timesource)
timesource


# In[19]:


from datetime import datetime
dt =datetime.strptime(timesource,'%Y年%m月%d日%H:%M')


# In[20]:


dt.strftime('%Y-%m-%d')


# In[24]:


soup.select('.time-source span a')[0].text


# In[36]:


article=[]
for p in soup.select('#artibody p')[:-1]:
    article.append(p.text.strip())
print(article)

'@'.join(article)


# In[38]:


' '.join([p.text.strip() for p in soup.select('#artibody p')[:-1]])


# In[43]:


soup.select('.article-editor')[0].text.lstrip('责任编辑')


# In[44]:


soup.select('#commentCount1')


# In[54]:


import requests
comments = requests.get('http://comment5.news.sina.com.cn/page/info?version=1&format=js&channel=gn&newsid=comos-fypnqvn0946790&group=&compress=0&ie=utf-8&oe=utf-8&page=1&page_size=20')
import json
jd = json.loads(comments.text.strip('var data='))


# In[57]:


jd['result']['count']['total']


# In[65]:


newsurl='http://news.sina.com.cn/gov/2017-12-07/doc-ifypnqvn0946790.shtml'
newsid = newsurl.split('/')[-1].rstrip('.shtml').lstrip('doc-i')
newsid


# In[72]:


import re
m = re.search('doc-i(.+).shtml',newsurl)
newsid = m.group(1)
newsid


# In[83]:


commentURL='http://comment5.news.sina.com.cn/page/info?version=1&format=js&channel=gn&newsid=comos-{}&group=&compress=0&ie=utf-8&oe=utf-8&page=1&page_size=20'
commentURL.format(newsid)


# In[84]:


import re
import json

def getComments(newsurl):
    m = re.search('doc-i(.+).shtml',newsurl)
    newsid = m.group(1)
    comments=requests.get(commentURL.format(newsid))
    jd = json.loads(comments.text.strip('var data='))
    return jd['result']['count']['total']


# In[85]:


news = 'http://news.sina.com.cn/gov/2017-12-07/doc-ifypnqvn0946790.shtml'

getComments(news)


# In[88]:


import requests
from bs4 import BeautifulSoup

def getNewsDetail(newsurl):
    result={}
    res = requests.get(newsurl)
    res.encoding='utf-8'
    soup = BeautifulSoup(res.text,'html.parser')
    result['title']=soup.select('#artibodyTitle')[0].text
    result['newssource']=soup.select('.time-source span a')[0].text
    timesource=soup.select('.time-source')[0].contents[0].strip()
    result['dt'] =datetime.strptime(timesource,'%Y年%m月%d日%H:%M')
    result['article']=' '.join([p.text.strip() for p in soup.select('#artibody p')[:-1]])
    result['editor']=soup.select('.article-editor')[0].text.lstrip('责任编辑') 
    result['comment']=getComments(newsurl)
    return result


# In[89]:


getNewsDetail('http://news.sina.com.cn/gov/2017-12-07/doc-ifypnqvn0946790.shtml')


# In[107]:


import requests
import json
res = requests.get('http://s.weibo.com/ajax/jsonp/suggestion?Refer=sina_sug&&_t1512718685031_22260997&_cb=jsonp_1512718685031_19256373')
#jd = json.loads(res.text)
#jd
res.text

