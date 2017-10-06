# ExamOnline123
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<p align="center"><em>高级软件工程 结对编程作业<em/></p>
<p align="center">姓名：李洋洋 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号：2017202160012</p>
<p align="center">姓名：李耀东 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号：2017202160014</p>

## 简介
奥数（小学）试卷生成系统
1).系统能够对特定年级奥数题所涉及的知识点进行注册和管理。

2).知识点之间可能有依赖关系，能够以可视化界面的方式呈现知识点之间的关系

3).用户提供题目总数，总体难度，生成一份满足要求的试卷

4).在用户给出答案后，能够对用户不熟悉的知识点进行判断
## 使用技术

架构：B/S

web框架：MVC

数据库：MySQL
## 1、预计时间psp表格   
|Project| Estimated time (:h)|Actual Time (:h)|
| - | :-: |-: |
| __Planning__ | 2|  2|
|estimate| 2| 2|
| __Development__|46 ||
|  Analysis |3 |5 |
| Design Spec|3 | |
| Design Review| 1| |
| Coding Standard|1 | |
|Design |2 | |
|Coding |30 | |
|Code Review |3 | |
|Test| 3| |
|__Reporting__ | 7| |
| Test Report|2 | |
|Size Measurement |2 | |
|Postmortem & Process Improvement Plan| 3| |

## 2、需求

根据老师的给出的需求,我们决定将系统分为4个功能,分别为知识点管理、知识点关系呈现、生成试卷和知识点判断。
用户可以根据需求选择相应功能，这些功能前提都是登陆系统，具体如下图所示：

![image](http://ww3.sinaimg.cn/large/0060lm7Tly1fk8mtng1fgj30ig0hkta2.jpg)
