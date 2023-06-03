# PrimaryCalculator

#项目简介

```bash
这是一个Java作业，写了一个初级计算器，本来算法是使用Java写的，但是后续如果要添加按键的话就会非常麻烦，这里选择调用Python来进行计算

UI是纯Java做的；计算利用Python可以直接运行字符串特点进行计算

本来想使用体积小的Jython来进行计算，但是Jython只支持到Python 2.7.2版本，Python2计算和Java一样需要设置变量类型，因此选择调用Python3计算

GradientButtonTextUI类用来设置JButton字体，设置JButton字体颜色循环渐变，单色变换显得突兀，于是使用颜色插值法来填充两种颜色的中间色

MyPane类用来设置JFrame窗口的ContentPane，setBackground并不能设置ContentPane，只有setContentPane才可以，此类中将ContentPane设置为三月七

PrimaryCalculator类是计算器的主体，调用其他类绘制计算器UI并调用Python进行计算

RoundButton类用来设置按键触发范围

RoundedBorder类用来绘制JButton圆角边框
```

#项目结构

```bash
├───src
│   ├───hy
│   │   ├───java
│   │   │   ├───GradientButtonTextUI
│   │   │   ├───MyPane
│   │   │   ├───PrimaryCalculator
│   │   │   ├───RoundButton
│   │   │   └───RoundedBorder
│   │   ├───Resources
│   │   │   ├───Image
│   │   │   │   ├───March 7 verticval screen version
│   │   │   └───Python37
```

#环境配置

```bash
用Maven更新一下就好了，可能不需要，最后没用到Jython
```
